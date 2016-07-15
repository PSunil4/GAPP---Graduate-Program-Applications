package gapp.util;

import java.beans.PropertyEditorSupport;

public class IntEditor extends PropertyEditorSupport {

    @SuppressWarnings("rawtypes")
    private Class clazz;

    public IntEditor( Class clazz )
    {
        this.clazz = clazz;
    }

    public String getAsText()
    {
        Integer value = (Integer) getValue();
        if( value.intValue() == 0 )
        {
            return "";
        }
        else
        {
            return value.toString();
        }
    }

    public void setAsText( String value )
    {
        if( value != null && value.length() > 0 )
        {
            setValue( Integer.parseInt( value ) );
        }
        else
        {
            setValue( 0 );
        }
    }

}
