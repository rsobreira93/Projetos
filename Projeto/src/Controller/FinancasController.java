package Controller;

import Main.Main;
import Modelo.Cliente;
import ModeloDao.ClienteDAO;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FinancasController implements Initializable{
    private Parent nova;
@FXML
    private ImageView inicioImg1;

    @FXML
    private DatePicker InicioPeriodo;

    @FXML
    private Button GerarButton;

    @FXML
    private Button inicioButton;

    @FXML
    private Button enfButton;

    @FXML
    private Button sairButton;

    @FXML
    private Button voltarButton;

    @FXML
    private DatePicker FimPeriodo;

    @FXML
    void sairButtonAction(ActionEvent event) {
        try {
            nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(FinancasController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void voltarButtonAction(ActionEvent event){
        try {
            nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(FinancasController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void inicioButtonAction(ActionEvent event){
        try {
            nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(FinancasController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void GerarButtonAction(ActionEvent event) throws BadElementException, IOException {
        gerarPdf();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }

    public void gerarPdf() throws BadElementException, IOException{
       Document doc = new Document();
       FileChooser f = new FileChooser();
       f.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF","*.pdf"));
       File arq = f.showSaveDialog(new Stage());
       if(arq != null){
            try {
               try {
                   PdfWriter.getInstance(doc, new FileOutputStream(arq.getAbsolutePath()));
                   doc.open();
     
                   Image logo = Image.getInstance("C:\\Users\\João Victor Queiroz\\Documents\\GitHub\\Projetos\\Projeto\\src\\icons\\Anamary logo.png");
                   logo.scaleAbsolute(221, 115);
                   logo.setAlignment(Element.ALIGN_CENTER);
                   doc.add(logo);
                   Paragraph cabecalho = new Paragraph("RELATÓRIO DE VENDAS");
                   cabecalho.setAlignment(Element.ALIGN_CENTER);
                   doc.add(new Paragraph("                  "));
                   doc.add(new Paragraph("                  "));
                   
                   Paragraph vGeral = new Paragraph("VISÃO GERAL");
                   vGeral.setAlignment(Element.ALIGN_CENTER);
                   doc.add(new Paragraph("                  "));
                   doc.add(new Paragraph("Valor total: R$0,00"));
                   doc.add(new Paragraph("Quantidade de vendas: 0"));
                   doc.add(new Paragraph("Média das vendas: R$0,00"));
                   doc.add(new Paragraph("Lucro Estimado: R$0,00"));
                   doc.add(new Paragraph("Produto mais vendido: Nenhum produto foi vendido"));
                   doc.add(new Paragraph("                  "));
                   doc.add(new Paragraph("                  "));
                   
                   Paragraph historico = new Paragraph("HISTÓRICO");
                   doc.add(new Paragraph("                  "));
                   PdfPTable tabela = new PdfPTable (3);
                   PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
                   col1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                   PdfPCell col2 = new PdfPCell(new Paragraph("CPF"));
                   col2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                   PdfPCell col3 = new PdfPCell(new Paragraph("Telefone"));
                   col3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                   tabela.addCell(col1);
                   tabela.addCell(col2);
                   tabela.addCell(col3);
                   
                   List<Cliente> clientes = new ClienteDAO().getList();
                   for(int x = 0; x < clientes.size(); x++){
                    tabela.addCell(new Paragraph(clientes.get(x).getNome()));
                    tabela.addCell(new Paragraph(clientes.get(x).getCpf()));
                    tabela.addCell(new Paragraph(clientes.get(x).getTelefone()));
                   }
                   doc.add(tabela);
                   doc.close();
                   Alert a = new Alert(AlertType.CONFIRMATION);
                   a.setHeaderText("Relatório gerado com sucesso.");
                   a.show();
               } catch (DocumentException ex) {
                   Logger.getLogger(FinancasController.class.getName()).log(Level.SEVERE, null, ex);
               }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FinancasController.class.getName()).log(Level.SEVERE, null, ex);
            }
       }else{
           Alert a = new Alert(AlertType.INFORMATION);
           a.setHeaderText("Defina um lugar parasalvar o arquivo.");
           a.show();
       }
    } 
    
}
