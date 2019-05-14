          package com.prjcadcliente.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.prjcadcliente.dominio.Cliente;

/**
 * <b>CRUDCliente</b><br>
 * Essa classe permite manipular as informa��es do cliente. Aqui voc� encontrar� os seguintes comandos:
 * <ul>
 * <li> Cadastro</li>
 * <li> Pesquisar por nome e por id</li>
 * <li> Atualizar</li>
 * <li> Deletar</li>
 * @author Murillo.raramos
 *
 */
          
          public class CRUDCliente {
        	  //Declara��o das inst�ncias de comunica��o com o banco de dados
        	  private Connection con = null;
        	  private ResultSet res = null;
        	  private PreparedStatement pst = null;
        	  public String cadastrar(Cliente cliente ) {
        		  
        		  String msg = "";
        		  
        		  //Cria��o dos objetos para a conexao com o banco de dados
        		  try {
        			  Class.forName("com.mysql.cj.jdbc.Drive").newInstance();
        			  con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clientedb","root","");
        			  
        			  String Consulta = "INSERT INTO tbcliente(nome, email, telefone, idade)values(?,?,?,?)";
        			  
        			  pst = con.prepareStatement(Consulta);
        			  
        			  pst.setString(1,  cliente.getNome());
        			  pst.setString(2, cliente.getEmail());
        			  pst.setString(3, cliente.getTelefone());
        			  int r = pst.executeUpdate();
        		
        			  if(r > 0)
        				  msg = "Cadastro realizado com sucesso!";
        			  else
        				  msg = "N�o foi poss�vel cadastrar!";
        			  }  
        		  catch(SQLException ex) {
        			  msg = "Erro ao tenar cadastrar:"+ex.getMessage();
        		  }
        		  catch(Exception e) {
        			  msg = "Erro inesperado:"+e.getMessage();
        			  }
        		  	finally {
        		  		try {con.close();}catch(Exception e) {e.printStackTrace();}
        		  	}
				return msg;
        	  }
        	  
        	  
        	  public String autalizar(Cliente cliente) {
 String msg = "";
        		  
        		  //Cria��o dos objetos para a conexao com o banco de dados
        		  try {
        			  Class.forName("com.mysql.cj.jdbc.Drive").newInstance();
        			  con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clientedb","root","");
        			  
        			  String Consulta = "UPDATE tbcliente(nome=?, email=?, telefone=?, idade=? WHERE id=?)values(?,?,?,?)";
        			  
        			  pst = con.prepareStatement(Consulta);
        			  
        			  pst.setString(1,  cliente.getNome());
        			  pst.setString(2, cliente.getEmail());
        			  pst.setString(3, cliente.getTelefone());
        			  pst.setInt(5, Cliente.getId());
        			  int r = pst.executeUpdate();
        		
        			  if(r > 0)
        				  msg = "Cadastro realizado com sucesso!";
        			  else
        				  msg = "N�o foi poss�vel cadastrar!";
        			  }  
        		  catch(SQLException ex) {
        			  msg = "Erro ao tenar cadastrar:"+ex.getMessage();
        		  }
        		  catch(Exception e) {
        			  msg = "Erro inesperado:"+e.getMessage();
        			  }
        		  	finally {
        		  		try {con.close();}catch(Exception e) {e.printStackTrace();}
        		  	}
				return msg;
        	  }
        	  public String deletar(Cliente cliente) {
 String msg = "";
        		  
        		  //Cria��o dos objetos para a conexao com o banco de dados
        		  try {
        			  Class.forName("com.mysql.cj.jdbc.Drive").newInstance();
        			  con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clientedb","root","");
        			  
        			  String Consulta = "DELETE FROM tbcliente WHERE id=?";
        			  
        			  pst = con.prepareStatement(Consulta);
        			  
        			 pst.setInt(1, cliente.getId());
        			  int r = pst.executeUpdate();
        		
        			  if(r > 0)
        				  msg = "Cadastro realizado com sucesso!";
        			  else
        				  msg = "N�o foi poss�vel cadastrar!";
        			  }  
        		  catch(SQLException ex) {
        			  msg = "Erro ao tenar deletar:"+ex.getMessage();
        		  }
        		  catch(Exception e) {
        			  msg = "Erro inesperado:"+e.getMessage();
        			  }
        		  	finally {
        		  		try {con.close();}catch(Exception e) {e.printStackTrace();}
        		  	}
				return msg;
        	  }
        	  public List<Cliente> PesquisarPorNome(String nome) {
        		  return null;
        	  }
        	  public List<Cliente> PesquisarPorId(int id){
        		  return null;
        	  }

        	  public List<Cliente> PesquisarTodos(){
        		  return null;
        	  }
}
