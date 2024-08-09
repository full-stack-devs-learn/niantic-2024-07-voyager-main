package com.niantic.services;

import com.niantic.models.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class TransactionDao
{
    JdbcTemplate jdbcTemplate;

    public ArrayList<Transaction> getAllTransactions()
    {
        var transactions = new ArrayList<Transaction>();

        String sql = "";

        var row = jdbcTemplate.queryForRowSet(sql);

        while(row.next())
        {
            LocalDate transactionDate = null;
            Date date = row.getDate("transaction_date");
            if(date != null)
            {
                transactionDate = date.toLocalDate();
            }

            BigDecimal amount = row.getBigDecimal("amount");
        }

        return transactions;
    }
}
