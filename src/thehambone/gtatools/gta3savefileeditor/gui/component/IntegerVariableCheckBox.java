
package thehambone.gtatools.gta3savefileeditor.gui.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import thehambone.gtatools.gta3savefileeditor.newshit.struct.var.IntegerVariable;
import thehambone.gtatools.gta3savefileeditor.util.Logger;

/**
 * Created on Jan 13, 2016.
 *
 * @author thehambone
 */
public class IntegerVariableCheckBox
        extends JCheckBox implements VariableComponent<IntegerVariable>
{
    private IntegerVariable var;
    private int deselectedValue;
    private int selectedValue;
    
    public IntegerVariableCheckBox()
    {
        this(null, 0, 1);
    }
    
    public IntegerVariableCheckBox(IntegerVariable var, int deselectedValue,
            int selectedValue)
    {
        this.var = var;
        this.deselectedValue = deselectedValue;
        this.selectedValue = selectedValue;
        
        initActionListener();
    }
    
    public int getDeselectedValue()
    {
        return deselectedValue;
    }
    
    public void setDeselectedValue(int value)
    {
        deselectedValue = value;
    }
    
    public int getSelectedValue()
    {
        return selectedValue;
    }
    
    public void setSelectedValue(int value)
    {
        selectedValue = value;
    }
    
    private void initActionListener()
    {
        addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateVariable();
            }
        });
    }
    
    @Override
    public IntegerVariable getVariable()
    {
        return var;
    }
    
    @Override
    public void setVariable(IntegerVariable var)
    {
        this.var = var;
        
        refreshComponent();
    }
    
    @Override
    public void refreshComponent()
    {
        if (var == null) {
            return;
        }
        
        int val = Integer.parseInt(var.getValue().toString());
        
        setSelected(val == selectedValue);
    }
    
    @Override
    public void updateVariable()
    {
        if (var == null) {
            return;
        }
        
        int val = isSelected() ? selectedValue : deselectedValue;
        var.parseValue(Integer.toString(val));
        Logger.debug("Variable updated: " + var);
    }
}
