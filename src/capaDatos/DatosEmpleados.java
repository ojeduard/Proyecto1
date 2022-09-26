package capaDatos;

import capaLogica.Empleado;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DatosEmpleados {
    private ArrayList<Empleado> listaEmpleados;

    public DatosEmpleados() {
        listaEmpleados = new ArrayList<>();
    }

    public Boolean guardarXML(String nombreArchivo){
        try{
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Files.deleteIfExists(Paths.get(nombreArchivo));

            //Crear la raiz del elemento
            Element root = document.createElement("EMPLEADOS");
            document.appendChild(root);

            for (Empleado empleado : listaEmpleados){
                Element empleadoXML = document.createElement("Empleado");
                root.appendChild(empleadoXML);

                // El representante de cada nodo cedula
                Attr attr = document.createAttribute("cedula");
                attr.setValue(empleado.getCedula());
                empleadoXML.setAttributeNode(attr);

                // El elemento nombre
                Element nombre = document.createElement("nombre");
                nombre.appendChild(document.createTextNode(empleado.getNombre()));

                // El elemento sucursalDeTrabajo
                Element sucursalDeTrabajo = document.createElement("sucursal");
                sucursalDeTrabajo.appendChild(document.createTextNode(empleado.getSucursalDeTrabajo()));

                // El elemento del salario base
                Element salarioBase = document.createElement("salarioBase");
                salarioBase.appendChild(document.createTextNode(String.valueOf(empleado.getSalarioBase())));

                //El elemento telefono
                Element telefono = document.createElement("telefono");
                telefono.appendChild(document.createTextNode(String.valueOf(empleado.getTelefono())));

                // Se crea ahora el archivo xml
                // Transforma el objeto DOM a un archivo XML
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource domSource = new DOMSource(document);
                StreamResult streamResult = new StreamResult(new File(nombreArchivo));

                transformer.transform(domSource, streamResult);
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public Boolean cargarXML (String nombreArchivo){

        try {
            // Igualemnte se utiliza el DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(nombreArchivo);

            NodeList nodeList = document.getDocumentElement().getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++){

                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element elem = (Element) node;

                    // Obtiene el valor del attr que seria el id
                    String cedula = ((Element) node).getAttributes().getNamedItem("id").getNodeValue();

                    // Obtiene todos los valotes de los sub-elementos
                    String nombre = elem.getElementsByTagName("name")
                            .item(0).getChildNodes().item(0).getNodeValue();

                    String sucursalDeTrabajo = elem.getElementsByTagName("sucursal")
                            .item(0).getChildNodes().item(0).getNodeValue();

                    double salarioBase = Double.parseDouble(elem.getElementsByTagName("salarioBase")
                            .item(0).getChildNodes().item(0).getNodeValue());

                    int telefono = Integer.parseInt(elem.getElementsByTagName("telefono")
                            .item(0).getChildNodes().item(0).getNodeValue());

                    listaEmpleados.add(new Empleado(cedula, nombre, sucursalDeTrabajo, salarioBase, telefono));
                }
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public ArrayList<Empleado> obtenerDatos(String nombreArchivo){
        listaEmpleados = new ArrayList<>();

        // Actualiza la lista de empleados
        cargarXML(nombreArchivo);

        return listaEmpleados;
    }
}
