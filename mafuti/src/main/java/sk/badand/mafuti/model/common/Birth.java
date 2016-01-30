/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.mafuti.model.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author abadinka
 */
public class Birth {

    private final Calendar birthDate;
    private final SimpleDateFormat simpleFormat = new SimpleDateFormat("dd. MM. yyyy");

    public Birth(Date birthDate) {
        this.birthDate = Calendar.getInstance();
        this.birthDate.setTime(birthDate);
    }

    public byte getAge(Date now) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);

        byte age = (byte) (cal.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR));
        if (cal.get(Calendar.MONTH) < birthDate.get(Calendar.MONTH)
                || (cal.get(Calendar.MONTH) == birthDate.get(Calendar.MONTH) && cal.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }
        return age;
    }

    public String getBirthDate() {
        return simpleFormat.format(birthDate.getTime());
    }
}
