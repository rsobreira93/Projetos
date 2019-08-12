package Controller;

import Main.Main;
import Modelo.Cliente;
import Modelo.Venda;
import ModeloDao.ClienteDAO;
import ModeloDao.VendaDao;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
/**
 * Classe responsavel por gerar relatorios.
 * @author Romulo Sobreira
 */
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
    void GerarButtonAction(ActionEvent event) throws BadElementException, IOException, SQLException {
        gerarPdf();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    
    }

    public void gerarPdf() throws BadElementException, IOException, SQLException{
       Document doc = new Document();
       doc.setPageSize(PageSize.A4.rotate());
       FileChooser f = new FileChooser();
       f.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF","*.pdf"));
       File arq = f.showSaveDialog(new Stage());
       if(arq != null){
            try {
               try {
                   PdfWriter.getInstance(doc, new FileOutputStream(arq.getAbsolutePath()));
                   doc.open();
                   float valorTotal=0, mediaVendas=(float) 0.0, lucro=0, precoCusto=0;
                   int quantVenda=0;
                   List<Venda> vendas = new VendaDao().getList2();
                   for (int y=0 ;y < vendas.size();y++){
                      valorTotal+=vendas.get(y).getValorVenda();
                      precoCusto+=vendas.get(y).getPrecoCusto();
                      quantVenda++;
                   }
                   mediaVendas= valorTotal/quantVenda;
                   lucro= valorTotal-precoCusto;
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
                   doc.add(new Paragraph("Valor total: R$"+valorTotal));
                   doc.add(new Paragraph("                  "));
                   doc.add(new Paragraph("Quantidade de vendas: "+quantVenda));
                   doc.add(new Paragraph("                  "));
                   doc.add(new Paragraph("Média das vendas: R$"+mediaVendas));
                   doc.add(new Paragraph("                  "));
                   doc.add(new Paragraph("Lucro Estimado: R$"+lucro));
                   
                   doc.add(new Paragraph("                  "));
                   doc.add(new Paragraph("                  "));
                   
                   Paragraph historico = new Paragraph("HISTÓRICO");
                   doc.add(new Paragraph("                  "));
                   PdfPTable tabela = new PdfPTable (3);
                   PdfPCell col1 = new PdfPCell(new Paragraph("Cliente"));
                   col1.setBackgroundColor(BaseColor.LIGHT_GRAY);
                   PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
                   col2.setBackgroundColor(BaseColor.LIGHT_GRAY);
                   PdfPCell col3 = new PdfPCell(new Paragraph("Quantidade"));
                   col3.setBackgroundColor(BaseColor.LIGHT_GRAY);
                   PdfPCell col4 = new PdfPCell(new Paragraph("Preço da venda"));
                   col4.setBackgroundColor(BaseColor.LIGHT_GRAY);
                   PdfPCell col5 = new PdfPCell(new Paragraph("Data da Venda"));
                   col5.setBackgroundColor(BaseColor.LIGHT_GRAY);
                   tabela.addCell(col1);
                   tabela.addCell(col2);
                   tabela.addCell(col3);
                   tabela.addCell(col4);
                   tabela.addCell(col5);
                   
                   
                   for(int x = 0; x < vendas.size(); x++){
                    tabela.addCell(new Paragraph(vendas.get(x).getNomeCliente()));
                    tabela.addCell(new Paragraph(vendas.get(x).getNomeProduto()));
                    tabela.addCell(new Paragraph(vendas.get(x).getQtdItem()));
                    tabela.addCell(new Paragraph(vendas.get(x).getValorVenda()));
                    tabela.addCell(new Paragraph(vendas.get(x).getData()));
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
