/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connecthub;

import connecthub.interfaces.ValidationStrategy;

/**
 *
 * @author User
 */
public class EmailValidation implements ValidationStrategy {

    private static final String EMAIL_REGEX = "^[a-z0-9]+@[a-z]+\\.[a-z]+$";

    @Override
    public boolean validate(String data) {
        return data.matches(EMAIL_REGEX);
    }
}
