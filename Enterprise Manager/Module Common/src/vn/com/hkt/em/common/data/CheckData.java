/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.common.data;

/**
 * Đối tượng kiểm tra dữ liệu
 * @author BinLe
 */
public class CheckData {

    /**
     * Kiểm tra 1 chuỗi có phải là số Long hay không
     * Chú ý chuỗi rỗng mặc định là số 0(hợp lệ)
     * @param s:String chuỗi cần kiểm tra
     * @return boolean: có phải là số Long không
     */
    public boolean isLong(String s) {
        try {
            if (s != null && !s.isEmpty()) {
                long x = Long.valueOf(s);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Kiểm tra 1 chuỗi có phải là số Float hay không
     * Chú ý chuỗi rỗng mặc định là số 0(hợp lệ)
     * @param s:String chuỗi cần kiểm tra
     * @return boolean: có phải là số Float không
     */
    public boolean isFloat(String s) {
        try {
            if (s != null && !s.isEmpty()) {
                float x = Float.valueOf(s);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Kiểm tra 1 chuỗi có phải là số điện thoại không
     * Chú ý mặc định chuỗi rỗng là hợp lệ
     * @param s :String chuỗi kiểm tra
     * @return :boolean là số điện thoại hay không
     */
    public boolean isNumberPhone(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int i = 0;
        if (s.charAt(i) == '+') {
            i++;
        }
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isNumberString(String s) {
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}
