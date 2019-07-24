package com.stackroute.jdbc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {


        Simpledemo demo = new Simpledemo();
        System.out.println("normal print");
        demo.getemployeedetails();
        System.out.println("reverse");
        demo.getdetailsreverse();
        System.out.println("second row in reverse");
        demo.getEmployeeDetailsFromSecondRowInReverse();
        System.out.println("gender and name");
        demo.getEmployeeDetailsByNameAndGender("pranitha","f");
        DatabaseMetadataDemo datademo=new DatabaseMetadataDemo();
        System.out.println("Displaying the table metadata");
        datademo.displaymetadata();
ResultsetMetaDataDemo resultsetdemo=new ResultsetMetaDataDemo();
        System.out.println("displaying the result set metadata");
resultsetdemo.displayresultsetmetadata();

      // Batchdemo batch=new Batchdemo();
        //System.out.println("displaying batch");
        //batch.displaybatch();
        Rowset obj=new Rowset();
            System.out.println("displaying the rowset");
            obj.displayrowset();
           // Transactiondemo transactiondemo=new Transactiondemo();
        //System.out.println("displaying the transaction");
       // transactiondemo.displaytransaction();
        //System.out.println("Hello World!");
    }

}
