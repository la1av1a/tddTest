package chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr){
        PasswordStrength result = meter.meter(password);
        assertEquals(expStr,result);
    }

    @Test
    void meetsAllCriteria_Then_Strong(){
        assertStrength("ab12!@AB",PasswordStrength.STRONG);
        assertStrength("abc1!Add",PasswordStrength.STRONG);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal(){
        assertStrength("ab12!@A",PasswordStrength.NORMAL);

        //길이가 8 미만이고 나머지 조건은 충족하는 암호
        assertStrength("Ab12!c",PasswordStrength.NORMAL);
    }

    //@DisplayName("숫자를 포함하지 않고 나머지 조건은 충족하는 암호)
    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal(){
        assertStrength("ab!@ABqwer",PasswordStrength.NORMAL);
    }

    @Test
    void nullInput_Then_Invalid(){
        assertStrength(null,PasswordStrength.INVALID);
        assertStrength("",PasswordStrength.INVALID);
    }

    @Test
    //@Displayname("대문자를 포함하지 않고 나머지 조건을 충족하는 경우)
    void meetsOtherCriteria_except_for_UpperCase_Then_Normal(){
        assertStrength("ab12!@df",PasswordStrength.NORMAL);
    }
}
