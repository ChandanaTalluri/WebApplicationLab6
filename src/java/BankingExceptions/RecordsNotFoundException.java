/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BankingExceptions;

/**
 *
 * @author gorilla
 */
public class RecordsNotFoundException extends Exception{
     public RecordsNotFoundException(String strErrorMessage){
       super(strErrorMessage);
   }
}
