/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.registro.validators;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author alvaroMC
 */
@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
         //To change body of generated methods, choose Tools | Templates.
        
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
        Matcher matcher = pattern.matcher((CharSequence) value);
        HtmlInputText htmlInputText = (HtmlInputText) component; 
        String label;
        
        if(htmlInputText.getLabel() == null || htmlInputText.getLabel().equals("")){
            label = htmlInputText.getId();
        }else{
            label = htmlInputText.getLabel();
        }
        
        if(!matcher.matches()){
            FacesMessage facesMessage = new FacesMessage(label + ": no es una dirección email válida");
            throw new ValidatorException(facesMessage);
        }
        
        
    }
    
    
}
