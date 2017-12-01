package com.blibli.dao.category;

import com.blibli.dao.My_Connection;
import com.blibli.dao_api.TransactionInterface;
import com.blibli.model.Detil_Transaction;
import com.blibli.model.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
@Repository
public class TransactionDao extends My_Connection implements TransactionInterface {
    @Override
    public void saveTransaction(Transaction transaction){
        String psql;
        if(transaction.getTransaction_id()!=0){
            System.out.println("updating transaction");

            psql="UPDATE transaction SET employee_id=?, total_pembelian=?," +
                    "total_pembayaran=?, tanggal_transaksi=CURRENT_DATE  where transaction_id= ?";
            try {
                this.makeConnection();
                System.out.println("test update buku");
                PreparedStatement preparedStatement= this.con.prepareStatement(psql);
                preparedStatement.setInt(1,transaction.getEmployee_id());
                preparedStatement.setDouble(2,transaction.getTotal_pembelian());
                preparedStatement.setDouble(3,transaction.getTotal_pembayaran());
                preparedStatement.setInt(4,transaction.getTransaction_id());
                preparedStatement.executeUpdate();
                System.out.println("suskes update");
                this.disconnect();

            }catch (Exception e){
                System.out.println(e);
            }
        }
        else{
            psql = "Insert into transaction(employee_id,total_pembelian,total_pembayaran,tanggal_transaksi)"+
                    " values (?,0,0,CURRENT_DATE)";
            try {
                this.makeConnection();

                PreparedStatement preparedStatement= this.con.prepareStatement(psql);
                preparedStatement.setInt(1,transaction.getEmployee_id());
                preparedStatement.executeUpdate();

                this.disconnect();

            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    @Override
    public void saveDetailTransaction(Detil_Transaction detil){
        String psql;
        if(detil.getDetil_id()!=0){
            System.out.println("updating detil_transaction");

            psql="UPDATE transaction SET transaction_id=?, book_id=?,quantity=?, unit_price=?, discount=? where detil_id= ?";
            try {
                this.makeConnection();
                System.out.println("test update buku");
                PreparedStatement preparedStatement= this.con.prepareStatement(psql);
                preparedStatement.setInt(1,detil.getTransaction_id());
                preparedStatement.setInt(2,detil.getBook_id());
                preparedStatement.setInt(3,detil.getQuantity());
                preparedStatement.setDouble(4,detil.getUnit_price());
                preparedStatement.setInt(5,detil.getDiscountDetil());
                preparedStatement.setInt(6,detil.getDetil_id());
                preparedStatement.executeUpdate();
                System.out.println("suskes update");
                this.disconnect();

            }catch (Exception e){
                System.out.println(e);
            }
        }
        else{
            psql = "Insert into detil_transaction(transaction_id,book_id,quantity,unit_price, discount)"+
                    " values (?,?,?,?,?)";
            try {
                this.makeConnection();
                PreparedStatement preparedStatement= this.con.prepareStatement(psql);
                preparedStatement.setInt(1,detil.getTransaction_id());
                preparedStatement.setInt(2,detil.getBook_id());
                preparedStatement.setInt(3,detil.getQuantity());
                preparedStatement.setDouble(4,detil.getUnit_price());
                preparedStatement.setInt(5,detil.getDiscountDetil());
                preparedStatement.executeUpdate();

                this.disconnect();

            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
    @Override
    public void deleteDetailTransaction(int idDetil){
        String psql= "Delete from detil_transaction where detail_id='"+idDetil+"';";
        try {
            this.makeConnection();
            Statement statement=this.con.createStatement();
            statement.executeQuery(psql);
            System.out.println("berhasil menghapus data detil");
            this.disconnect();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}