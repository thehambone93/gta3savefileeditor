
package thehambone.gtatools.gta3savefileeditor.gui.component;

import java.util.List;
import thehambone.gtatools.gta3savefileeditor.gui.observe.Observable;
import thehambone.gtatools.gta3savefileeditor.newshit.struct.var.Variable;


/**
 * Created on Jan 10, 2016.
 *
 * @author thehambone
 * @param <T>
 */
public interface VariableComponent<T extends Variable> extends Observable
{
    public boolean hasVariable();
    
    public T getVariable();
    
    public void setVariable(T var, T... supplementaryVars);
    
    public List<T> getSupplementaryVariables();
    
    /**
     * Sets whether the variable should be updated when the component state
     * changes.
     * 
     * @param doUpdate a boolean indicating whether to update the variable
     */
    public void updateVariableOnChange(boolean doUpdate);
    
    /**
     * Sets the data displayed by the component based on the current value of
     * the variable.
     */
    public void refreshComponent();
    
    /**
     * Sets the value of variable based on the data currently displayed by the
     * component.
     */
    public void updateVariable();
}