package com.baizhi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusiParams {
//     "billId": "13838245229",
//        "custCertNo": "dc100ac0790a6e204d449c72427d34b78e88df134a310a25",
//        "custName": "300859b8a5bdd109"
    private String  billId;
    private String  custCertNo;
    private String  custName;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCustCertNo() {
        return custCertNo;
    }

    public void setCustCertNo(String custCertNo) {
        this.custCertNo = custCertNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }
}
