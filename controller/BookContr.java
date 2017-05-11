package controller;

import parser.ParserXML;

import Model.Book;
import Model.Report;
import Model.FactoryReport;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BookContr {

    public static DefaultTableModel listBySearchItem(String item)
    {
        ArrayList<Book> books = getBySearchItem(item);
        return buildBooksTable(books);
    }

    public static ArrayList<Book> getBySearchItem(String searchItem)
    {
        ArrayList<Book> sortedBooks= new ArrayList<>();
        ArrayList<String> books = new ArrayList<>();

            NodeList nList = ParserXML.getNodeListByTag("books.xml","book");

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        books.add(eElement.getElementsByTagName(searchItem).item(0).getTextContent());
                    }
                }

                List<String> sublist = books.subList(0, books.size());
                Collections.sort(sublist);

                for (int pos = 0; pos < sublist.size(); pos++)
                    for (int i = 0; i < nList.getLength(); i++) {
                        Node nNode = nList.item(i);
                        Element element = (Element) nNode;
                        String elemTitle = element.getElementsByTagName(searchItem).item(0).getTextContent();
                        if (sublist.get(pos).equals(elemTitle)) {
                            Book book = new Book();
                            book.setTitle(element.getElementsByTagName("title").item(0).getTextContent());
                            book.setAuthor(element.getElementsByTagName("author").item(0).getTextContent());
                            book.setGenre(element.getElementsByTagName("genre").item(0).getTextContent());
                            book.setQuantity(element.getElementsByTagName("quantity").item(0).getTextContent());
                            book.setPrice(element.getElementsByTagName("price").item(0).getTextContent());
                            sortedBooks.add(book);
                        }
                    }
        return sortedBooks;
    }
    public static ArrayList<Book> findAllBooks()
    {
        ArrayList<Book> books= new ArrayList<Book>();

            NodeList nList = ParserXML.getNodeListByTag("books.xml","book");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Book book = new Book();
                    book.setId(eElement.getAttribute("id"));
                    book.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
                    book.setAuthor(eElement.getElementsByTagName("author").item(0).getTextContent());
                    book.setGenre(eElement.getElementsByTagName("genre").item(0).getTextContent());
                    book.setQuantity(eElement.getElementsByTagName("quantity").item(0).getTextContent());
                    book.setPrice(eElement.getElementsByTagName("price").item(0).getTextContent());
                    books.add(book);
                }
            }
        return books;
    }
    public static DefaultTableModel buildBooksTable(ArrayList<Book> list) {

        String[] columnNames = {
                "Title",
                "Author",
                "Genre",
                "Quantity",
                "Price"
        };

        Object[][] array = new Object[list.size()][];
        int i = 0;
        for (Book c : list)
        {
            array[i] = new Object[5];
            array[i][0] = c.getTitle();
            array[i][1] = c.getAuthor();
            array[i][2]=c.getGenre();
            array[i][3] = c.getQuantity();
            array[i][4] = c.getPrice();
            i++;
        }
        return new DefaultTableModel(array, columnNames);
    }
    public static DefaultTableModel listAllBooks() {

        ArrayList<Book> books = findAllBooks();
        return buildBooksTable(books);
    }

    public static void deleteBook(String title)
    {
            NodeList nList = ParserXML.getNodeListByTag("books.xml","book");
            for (int i=0;i<nList.getLength();i++)
            {
                Element book = (Element)nList.item(i);
                Element name = (Element)book.getElementsByTagName("title").item(0);
                String pName = name.getTextContent();
                if (pName.equals(title)) {
                    book.getParentNode().removeChild(book);
                }
            }
            ParserXML.updateXML("books.xml");

    }
    public static void updateBook(String title, String toChange, String past, String future,String quant)
    {
            NodeList nList = ParserXML.getNodeListByTag("books.xml","book");
            //update attribute value
            //updateAttributeValue(doc);

            //update Element value
            //updateElementValue(doc);

            //delete element
            // deleteElement(doc);

            //add new element
            // addElement(doc);
            if (title.equals("")) {
                updateTitle(nList, toChange, past, future);
            } else if (!toChange.equals("vinde"))
            {
                updateBookElement(nList, title, toChange, future);
            }

            if (toChange.equals("vinde"))
            {
            	System.out.println("ajung aici");
                sellBook(nList,title,Integer.parseInt(quant));
            }
        ParserXML.updateXML("books.xml");

    }

    /**
     * Modifies an attribute value
     * an attribute is, for example <book id="this is an attribute"></book>
     */
//    private static void updateAttributeValue(Document doc) {
//        NodeList books = doc.getElementsByTagName("book");
//        Element emp = null;
//        //loop for each employee
//        for(int i=0; i<books.getLength();i++){
//            emp = (Element) books.item(i);
//            String genre = emp.getElementsByTagName("genre").item(0).getTextContent();
//            if(genre.equals("realism")){
//                //prefix id attribute with M
//                emp.setAttribute("quantity", "1");
//
//            }else{
//                //prefix id attribute with F
//                emp.setAttribute("quantity", "-1");
//            }
//        }
//    }
//
//    /**
//     * Modifies the element quantity
//     * an element is, for example, <quantity>relevant data</quantity>
//     * @param doc
//     */
//    private static void updateElementValue(Document doc) {
//        NodeList employees = doc.getElementsByTagName("book");
//        Element emp = null;
//        //loop for each employee
//        for(int i=0; i<employees.getLength();i++){
//            emp = (Element) employees.item(i);
//            String genre = emp.getElementsByTagName("genre").item(0).getTextContent();
//            Node quantity=emp.getElementsByTagName("quantity").item(0).getFirstChild();
//            if(genre.equals("realism")){
//                //prefix id attribute with M
//                quantity.setNodeValue("2");
//
//            }else{
//                //prefix id attribute with F
//                quantity.setNodeValue("1");
//            }
//        }
//    }
    private static void updateTitle(NodeList books,String whatToChange, String old, String newOne)
    {
       
        Element book ;
       
        for (int i=0; i<books.getLength(); i++)
        {
            book = (Element) books.item(i);
            String oldBook= book.getElementsByTagName(whatToChange).item(0).getTextContent();
            Node newBook=book.getElementsByTagName(whatToChange).item(0).getFirstChild();
            if (oldBook.equals(old))
            {
                newBook.setNodeValue(newOne);
            }
        }
    }

    public static void sellBook(NodeList books,String title,int quant)
    {
        Element book ;
       
        for (int i = 0; i < books.getLength(); i++) {
            book = (Element) books.item(i);
            String t = book.getElementsByTagName("title").item(0).getTextContent();
            if (t.equals(title)) {
                Node bookElement = book.getElementsByTagName("quantity").item(0).getFirstChild();//ia cantitatea
                String quantity = bookElement.getTextContent();
                int q = Integer.parseInt(quantity);
                if (quant>q)
                	System.out.println("Stoc insuficient");
                else
                	q-=quant;
                bookElement.setNodeValue(String.valueOf(q));
            }
        }
    }
    public static void updateBookElement(NodeList books,String title, String whatToChange, String newOne) {
       // NodeList books = doc.getElementsByTagName("book");
        Element book ;
        //loop for each employee
        for (int i = 0; i < books.getLength(); i++) {
            book = (Element) books.item(i);
            String t = book.getElementsByTagName("title").item(0).getTextContent();
            if (t.equals(title)) {
                Node bookElement = book.getElementsByTagName(whatToChange).item(0).getFirstChild();
                bookElement.setNodeValue(newOne);
            }
        }
    }


    public static void addBook(String inputTitle, String inputAuthor, String inputGenre, String inputQuantity, String inputPrice)
    {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("books.xml");
            Element root = document.getDocumentElement();

            Element newBook= document.createElement("book");

            Element title=document.createElement("title");
            title.appendChild(document.createTextNode(inputTitle));
            newBook.appendChild(title);

            Element author=document.createElement("author");
            author.appendChild(document.createTextNode(inputAuthor));
            newBook.appendChild(author);

            Element genre=document.createElement("genre");
            genre.appendChild(document.createTextNode(inputGenre));
            newBook.appendChild(genre);

            Element quantity=document.createElement("quantity");
            quantity.appendChild(document.createTextNode(inputQuantity));
            newBook.appendChild(quantity);

            Element price=document.createElement("price");
            price.appendChild(document.createTextNode(inputPrice));
            newBook.appendChild(price);

            root.appendChild(newBook);

            DOMSource source = new DOMSource(document);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("books.xml");
            transformer.transform(source, result);
        }
        catch (org.xml.sax.SAXException saxe1)
        {
            saxe1.printStackTrace();
        }
        catch (ParserConfigurationException pce1)
        {
            pce1.printStackTrace();
        }
        catch(IOException e1)
        {
            e1.printStackTrace();
        }
        catch (TransformerException te1)
        {
            te1.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void generateReport(String type)
    {
        FactoryReport reportObj= new FactoryReport();
        Report report =reportObj.getReport(type);
        System.out.println(type);
        ArrayList<String> titles = new ArrayList<>();
        NodeList books = ParserXML.getNodeListByTag("books.xml","book");
            Element book ;
         
            for (int i = 0; i < books.getLength(); i++) {
                book = (Element) books.item(i);
                //System.out.println(type);
                Node bookElement = book.getElementsByTagName("quantity").item(0).getFirstChild();
                String quantity = bookElement.getTextContent();
                int q = Integer.parseInt(quantity);
                if (q==0)
                {
                    String t = book.getElementsByTagName("title").item(0).getTextContent();
                    titles.add(t);
                }
                }
            try {
                report.generate(titles);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
}
