package controller;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class MainController 
{
	@FXML
    private Button getCode;
	
	@FXML
    private TextArea textWindow;
	
    @FXML
    private RadioButton con_if, 
    					con_ifElse,
    					con_if_ifElse_else,
    					con_switch, 
    					
    					loop_for, 
    					loop_while, 
    					loop_doWhile, 
    					loop_enhancedFor, 
    					
    					class_empty, 
    					class_emptyWithConstructor, 
    					
    					var_int, 
    					var_double, 
    					var_string, 
    					var_boolean,
    					var_char,
    					
    					method_void,
    					method_withReturn,
    					method_returnAndArgument,
    					method_withArgument,
    					method_constructor,
    					
    					systemOut;
    @FXML
    private CheckBox 	collection_array,
					    collection_arrayList,
					    collection_list;

    ArrayList<RadioButton> radioButtonList = new ArrayList<>();
    ArrayList<RadioButton> dataTypeList = new ArrayList<>();
    ArrayList<CheckBox> checkBoxList = new ArrayList<>();
    
    String selected_component = "", selectedVar = "", selectedType = "", basicDataType = "";
    RadioButton lastSelectedDataType = null;
    
    
    
    @FXML
    public void initialize()
    {    	
    	//data type list
    	dataTypeList.add(var_int);
    	dataTypeList.add(var_double);
    	dataTypeList.add(var_string);
    	dataTypeList.add(var_boolean);
    	dataTypeList.add(var_char);
    	
    	//radio buttons added to list
    	radioButtonList.add(con_if);
    	radioButtonList.add(con_ifElse);
    	radioButtonList.add(con_if_ifElse_else);
    	radioButtonList.add(con_switch);
    	
    	radioButtonList.add(loop_for);
    	radioButtonList.add(loop_while);
    	radioButtonList.add(loop_doWhile);
    	radioButtonList.add(loop_enhancedFor);
    	
    	radioButtonList.add(class_empty);
    	radioButtonList.add(class_emptyWithConstructor);
    	
    	radioButtonList.add(var_int);
    	radioButtonList.add(var_double);
    	radioButtonList.add(var_string);
    	radioButtonList.add(var_boolean);
    	radioButtonList.add(var_char);
    	
    	radioButtonList.add(method_void);
    	radioButtonList.add(method_withReturn);
    	radioButtonList.add(method_returnAndArgument);
    	radioButtonList.add(method_withArgument);
    	radioButtonList.add(method_constructor);    	
    	
    	
    	//check box buttons added to list
    	checkBoxList.add(collection_array);
    	checkBoxList.add(collection_arrayList);
    	checkBoxList.add(collection_list);
    }
     
    @FXML
    void process_variables(ActionEvent e) 
    {    	
    	//variables
    	processRadioButtonClick(e, var_char, "char");		
    	processRadioButtonClick(e, var_int, "int");    	
    	processRadioButtonClick(e, var_double, "double");
    	processRadioButtonClick(e, var_string, "String");
    	processRadioButtonClick(e, var_boolean, "boolean");
    	
    	//used to hold the last selected basic data type
    	basicDataType = selectedType;
    	
    	//collections
    	processCheckBoxesButtonClicks(e, collection_array, "array");
    	processCheckBoxesButtonClicks(e, collection_arrayList, "arrayList");
    	processCheckBoxesButtonClicks(e, collection_list, "list");

    	//whichCheckboxIsSelected();  
    }
    public void processCheckBoxesButtonClicks(ActionEvent e, CheckBox checkBox, String type)
    {
    	Object buttonPressed = e.getSource();
    	
    	if(buttonPressed == checkBox) 
    	{
    		selected_component = type; 
    		clearOtherCheckBoxes(checkBox);
    	}
    }
    public void processRadioButtonClick(ActionEvent e, RadioButton button, String type) 
    {
    	Object buttonPressed = e.getSource();
    	
    	if(buttonPressed == button) 
    	{
    		if(!type.isEmpty()) 
    		{    			
    			selectedType = type;
    			lastSelectedDataType = button; 
    			
    			if(	button == var_int || button == var_double || button == var_string || button == var_boolean || button == var_char) 
        		{ 						
    				clearOtherDataTypes();
        		}
    		}
    		    
    		selected_component = type;
    		selectedVar = selected_component;    		
    		
    		clearOtherClickedButtons(button);    		
    		clearAllButtons(button);
    	}
    }
        
   
    
    
    //clicks that come from the FXML file
    @FXML
    void process_conditionalLogic(ActionEvent e) 
    {
    	//conditional logic
    	processRadioButtonClick(e, con_if, 				"if_statement");
    	processRadioButtonClick(e, con_ifElse, 			"ifElse_statement");
    	processRadioButtonClick(e, con_if_ifElse_else, 	"if_ifElse_Else_statement");
    	processRadioButtonClick(e, con_switch, 			"switch");
    }
    @FXML
    void process_loop(ActionEvent e) 
    {
    	processRadioButtonClick(e, loop_for, 		 "for_Loop");
    	processRadioButtonClick(e, loop_while, 		 "while_Loop");
    	processRadioButtonClick(e, loop_doWhile, 	 "doWhile_Loop");
    	processRadioButtonClick(e, loop_enhancedFor, "enhancedFor_Loop");
    }
    @FXML
    void process_method(ActionEvent e) 
    {
    	processRadioButtonClick(e, method_void, 		 	 "void");
    	processRadioButtonClick(e, method_withReturn, 		 "withReturn");
    	processRadioButtonClick(e, method_returnAndArgument, "returnAndArgument");
    	processRadioButtonClick(e, method_withArgument, 	 "withArgument");
    	processRadioButtonClick(e, method_constructor, 		 "constructor");
    }
    @FXML
    void process_class(ActionEvent e) 
    {
    	processRadioButtonClick(e, class_empty, "empty");
    	processRadioButtonClick(e, class_emptyWithConstructor, "withConstructor");
    }
    @FXML
    void process_output(ActionEvent e) 
    {
    	processRadioButtonClick(e, systemOut, "output");
    }
    
    @FXML
    void getCode(ActionEvent event) 
    {
    	System.out.println("getting code...");
    	
    	//gets the correctly selected component and copies it to the clipboard
    	getSelectedCode(selected_component);
    	
    	//clears after clip board has been copied
    	this.selected_component = "";
    }
    public void getSelectedCode(String item) 
    {
    	String itemCopied = "";
    	switch(selected_component)
    	{
    		//variables
    		case "int": 		itemCopied = getInt(); 								break;
    		case "double": 		itemCopied = getDouble(); 							break;
    		case "boolean": 	itemCopied = getBoolean();							break;
    		case "char": 		itemCopied = getChar(); 							break;
    		case "String": 		itemCopied = getString(); 							break;    		
    		
    		//collections
    		case "array": 		itemCopied = getArray(selectedVar);					break;
    		case "arrayList": 	itemCopied = getArrayList(selectedVar);				break;
    		case "list": 		itemCopied = getList();								break;    		
    		
    		//conditional logic
    		case "if_statement": 				itemCopied = getIf();				break;
    		case "ifElse_statement": 			itemCopied = getIfElse();			break;
    		case "if_ifElse_Else_statement": 	itemCopied = getif_ifElse_Else();	break;
    		case "switch": 						itemCopied = getSwitch();			break;
    		
    		//loops
    		case "for_Loop": 			itemCopied = getFor_Loop();					break;
    		case "while_Loop": 			itemCopied = getWhile_Loop();				break;
    		case "doWhile_Loop": 		itemCopied = getDoWhile_Loop();				break;
    		case "enhancedFor_Loop": 	itemCopied = getEnhancedFor_Loop();			break;
    		
    		//methods
    		case "void": 				itemCopied = getVoid();						break;
    		case "withReturn": 			itemCopied = getWithReturn();				break;
    		case "returnAndArgument": 	itemCopied = getReturnAndArgument();		break;
    		case "withArgument": 		itemCopied = getWithArgument();				break;
    		case "constructor": 		itemCopied = getConstructor();				break;
    		
    		//classes
    		case "empty": 				itemCopied = getEmptyClass();				break;
    		case "withConstructor": 	itemCopied = getClassWithConstructor();		break;
    		
    		//output
    		case "output": 	itemCopied = getOutput();								break;
    	}
    	
    	System.out.println(itemCopied);    	
    	copyToClipBoard(itemCopied);
    }
    
    //variables
    public String getInt() 
    {
    	return "int var = 0;";
    }
    public String getDouble() 
    {
    	return "double var = 0.0;";
    }    
    public String getBoolean() 
    {
    	return "boolean var = false;";
    }
    public String getChar() 
    {
    	return "char var = 'A';";
    }
    public String getString() 
    {
    	return "String var = \"\";";
    }
    
    //collections
    public String getArray(String type) 
    {	
    	return type+"[] var = new "+type+"[1];";
    }
    public String getArrayList(String type) 
    {	
    	return "ArrayList<"+type+"> list = new ArrayList<"+type+">();";
    }
    public String getList() 
    {    	
    	return "List list = new List();";
    }
    
    //conditional logic
    public String getIf() 
    {
    	return "if()\n{\n\n}";
    }
    public String getIfElse() 
    {
    	return "if()\n{\n\n}\nelse\n{\n\n}";
    }
    public String getif_ifElse_Else() 
    {
    	return "if()\n"
    			+ "{\n\n}"
    			+ "\nelse if()"
    			+ "\n{\n\n}"
    			+ "\nelse"
    			+ "{\n\n}";
    }
    public String getSwitch() 
    {
    	if(basicDataType.isEmpty()) 
    	{
    		basicDataType = "DataType";
    	}  
    	
    	return basicDataType+" var = "+getValueFromType()+";\n"
    			+ "switch(var)\n{\n\tcase "+getValueFromType()+": break;\n\tdefault: break;\n}";
    }
    
    //loops
    public String getFor_Loop() 
    {
    	return "for(int x=0; x<10; x++)\n{\n\n}";
    }
    public String getWhile_Loop() 
    {
    	return "while(someConditionGoesHere)\n{\n\n}";
    }
    public String getDoWhile_Loop() 
    {
    	return "do{\n//stuff goes here\n}\nwhile(someConditionGoesHere);";
    }
    public String getEnhancedFor_Loop() 
    {
    	return "for(Datatype d: someCollectionOrList)\n{\n\n}";
    }
    
    //methods
    public String getVoid() 
    {
    	return "public void method()\n{\n\n}";
    }
    public String getWithReturn()
    {
    	if(basicDataType.isEmpty()) 
    	{
    		basicDataType = "DataType";
    	}  
    	
    	return "public "+basicDataType+" method()\n{\n\treturn "+basicDataType+";\n}";
    }
    public String getReturnAndArgument()
    {
    	if(basicDataType.isEmpty()) 
    	{
    		basicDataType = "DataType";
    	}  
    	
    	return "public "+basicDataType+" method("+basicDataType+" value)\n{\n\treturn "+basicDataType+";\n}";
    }
    public String getWithArgument() 
    {
    	if(basicDataType.isEmpty()) 
    	{
    		basicDataType = "DataType";
    	}    	
    	
    	return "public void method("+basicDataType+" value)\n{\n\n}";
    }
    public String getConstructor() 
    {
    	return "public ClassName()\n{\n\n}";
    }
    
    //classes
    public String getEmptyClass() 
    {
    	return "class SomeClassName\n{\n\n}";
    }
    public String getClassWithConstructor()
    {
    	return "class SomeClassName\n"
    			+ "{"
    			+ "\n\t//constructor of class"    			
    			+ " \n\tpublic SomeClassName()\n"
    			+ "\t{\n\n\t"
    			+ "}\n"
    			+ "}";
    }

    //output
    public String getOutput() 
    {
    	return "System.out.println(\"\");";
    }

    
    
    
    public String getValueFromType() 
    {
    	switch(basicDataType) 
    	{
	    	case "int": 		return "0";
	    	case "double": 		return "0.0";
	    	case "boolean": 	return "false";
	    	case "char": 		return "'A'";
	    	case "String": 		return "\"\"";
	    	default : return "";
    	}
    }
    public String getSelectedButton() 
    {
    	for(RadioButton b: radioButtonList) 
    	{
    		if(b.isSelected()) 
    		{
    			return b.getId();
    		}
    	}
    	return "";
    }
    public String whichCheckboxIsSelected() 
    {
    	for(CheckBox cb: checkBoxList) 
		{
			if(cb.isSelected()) 
			{
				return cb.getId();
			}
		}
    	return "";
    }
    public String convertCheckboxNameToString() 
    {    	
    	switch(whichCheckboxIsSelected()) 
    	{
	    	case "collection_array": 		return "array";
	    	case "collection_arrayList": 	return "arrayList";
	    	case "collection_list": 		return "list";
	    	default:  						return "";    	
    	}		
    }
    public void clearOtherCheckBoxes(CheckBox cbox) 
    {
    	for(CheckBox cb: checkBoxList) 
		{
			if(cb != cbox) 
			{
				cb.setSelected(false);
			}
		}
    	
    }
    public void clearOtherClickedButtons(RadioButton button) 
    {
    	for(RadioButton b: radioButtonList) 
    	{
    		//checks for a basic button data type, and ignores those
    		if(	b == var_int || b == var_double || b == var_string || b == var_boolean || b == var_char) 
    		{ 						
    			continue;
    		}
    		else if(b != button) 
    		{
    			b.setSelected(false);
    		}
    	}    	
    }
    public void copyToClipBoard(String textToCopy) 
    {   
    	//copy to text window
    	textWindow.setText(textToCopy);
    	
    	
    	//code which us used to copy to the system clip board    	
    	Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        
        //add string to this
        content.putString(textToCopy);
        
        //this copies to clip board
        clipboard.setContent(content);    	
    }
    public void clearOtherDataTypes() 
    {
    	for(RadioButton r: dataTypeList) 
    	{
    		if(r != lastSelectedDataType) 
			{
    			r.setSelected(false);
			}
			
    	}
    }
    public void clearAllButtons(RadioButton button) 
    {
    	for(RadioButton r: radioButtonList) 
    	{
    		if(	r == var_int || r == var_double || r == var_string || r == var_boolean || r == var_char) 
    		{
    			lastSelectedDataType = r;
    			   
    			continue;
    		}
    		else if(r != button) 
    		{
    			r.setSelected(false);
    		}
    	}
    	for(CheckBox c: checkBoxList) 
    	{
    		c.setSelected(false);
    	}    
    }
}