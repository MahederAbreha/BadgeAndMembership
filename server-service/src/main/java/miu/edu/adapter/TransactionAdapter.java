package miu.edu.adapter;

import miu.edu.domain.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionAdapter {
//    public TransactionDTO entityToDTO(Transaction transaction){
//        return new TransactionDTO(transaction.getId(), transaction.getTransactionStatusType(), transaction.getTransactionDateTime(), transaction.getMembership(), transaction.getLocation());
//    }
//
//    public List<TransactionDTO> entityToDtoAll(List<Transaction> transactions){
//        return transactions.stream().map(transaction -> entityToDTO(transaction)).collect(Collectors.toList());
//    }
//
//    public Transaction DtoToEntity(TransactionDTO transactionDTO){
//        return new Transaction(transactionDTO.getId(), transactionDTO.getStatus(), transactionDTO.getDateTime(), transactionDTO.getMembership(), transactionDTO.getLocation());
//    }
//
//    public List<Transaction> DtoToEntityAll(List<TransactionDTO> transactionDTOList){
//        return transactionDTOList.stream().map(transactionDTO -> DtoToEntity(transactionDTO)).collect(Collectors.toList());
//    }

}
