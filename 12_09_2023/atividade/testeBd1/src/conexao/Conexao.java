/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Admin
 */
package conexao;

import javax.swing.JOptionPane;
import java.sql.*;// para a execução de comandos SQL no ambiente JAVA

public class Conexao {
    final private String driver = "com.mysql.jdbc.Driver";// definição do Driver mysql para o acesso dos Dados
    final private String url = "jdbc:mysql://localhost/clientes";//acesso ao BD clientes no servidor
    final private String usuario = "root";//usuário do MYsql - usbwebserver
    final private String senha = "";// senha do MYsql - usbwebserver
    private Connection conexao;//váriavel que amazenara a conexão aberta
    public Statement statement;//váriavel para execução dos comandos SQL dentro do amiente JAVA
    public ResultSet resultset;//variável que armazenará o resultado da execução de um comando SQL

    public boolean conecta() {
        boolean result = true;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);
            JOptionPane.showMessageDialog(null,"Conexão estabelcida","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
        }catch (ClassNotFoundException Driver){
            JOptionPane.showMessageDialog(null,"Driver não localizado","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null,"Fonte de dados não localizada"+Fonte,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }
        return result;
    }
    
    public void desconecta()    {
        try {
            conexao.close();
            JOptionPane.showMessageDialog(null,"Conexão com o banco fechado","Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException fecha) {
            
        }
    }
    
    public void executarSQL(String sql) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        }catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null,"Erro no comando SQL! \n ERRO :"+excecao,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void executaSQL(String select__from_tbclientes_order_by_cod) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
                                                            