package com.camdyn.simplebankingapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camdyn.simplebankingapp.domain.business.AccountService;
import com.camdyn.simplebankingapp.domain.business.TransactionService;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private final TransactionService transactionService;

    @Autowired
    private final AccountService accountService;

    public TransactionController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

//    @GetMapping("/transactions")
//    public String getTransactionsByAccountId(@RequestParam long id) {
//        //TODO: process POST request
//        
//        return null;
//    }
    

//    @GetMapping("/transactions/${id}")
//    public Transaction getTransaction(@PathVariable Long id) {
//        return transactionService.findById(id);
//    }

// @PostMapping("/transaction/transfer")
// public List<Transaction> postTransfer(@RequestBody List<Transaction> request) {
//     try {
//         for (Transaction t : request) {
//             switch (t.getType()) {
//                 case Transaction.TransactionType.DEPOSIT.label:
//                     break;
//                 case Transaction.TransactionType.WITHDRAWAL.label:
//                     break;
//                 default:
//                     System.out.println("Something went wrong...");
//             }
//             
//         }
//     } catch (Exception e) {
//         // e.printStackTrace();
//     }
//     
//     return request;
// }

// @PostMapping("/transaction/deposit")
// public ResponseEntity<Transaction> postDeposit(@RequestBody Transaction request) {
//     try {
//         Transaction t = transactionService.createDeposit(request.getAmount(), request.getAccountId());
//         accountService.addBalance(t.getAccountId(), t.getAmount());
// 
//         return ResponseEntity.created();
//     } catch (Exception e) {
//         // e.printStackTrace();
//         return null;
//     }
// }



}
