package miu.edu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    String planId;
    String locationId;
    String checkerId;
    String badgeId;
    String memberId;
}
