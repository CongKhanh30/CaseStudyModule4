package com.be.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date datetime;
    @ManyToOne
    private Account account;


    public int getMonthFromTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.datetime);
        return calendar.get(Calendar.MONTH) + 1; // Tháng bắt đầu từ 0 nên cộng thêm 1
    }
}
