package net.bemperum.rpg;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class main extends javafx.application.Application{
public static main mostCurrent = new main();

public static BA ba;
static {
		ba = new  anywheresoftware.b4j.objects.FxBA("net.bemperum.rpg", "net.bemperum.rpg.main", null);
		ba.loadHtSubs(main.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "net.bemperum.rpg.main", ba);
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}

 
    public static void main(String[] args) {
    	launch(args);
    }
    public void start (javafx.stage.Stage stage) {
        try {
            if (!false)
                System.setProperty("prism.lcdtext", "false");
            anywheresoftware.b4j.objects.FxBA.application = this;
		    anywheresoftware.b4a.keywords.Common.setDensity(javafx.stage.Screen.getPrimary().getDpi());
            anywheresoftware.b4a.keywords.Common.LogDebug("Program started.");
            initializeProcessGlobals();
            anywheresoftware.b4j.objects.Form frm = new anywheresoftware.b4j.objects.Form();
            frm.initWithStage(ba, stage, 600, 600);
            ba.raiseEvent(null, "appstart", frm, (String[])getParameters().getRaw().toArray(new String[0]));
        } catch (Throwable t) {
            BA.printException(t, true);
            System.exit(1);
        }
    }
public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.objects.JFX _fx = null;
public static anywheresoftware.b4j.objects.Form _mainform = null;
public static anywheresoftware.b4j.objects.SliderWrapper _fldcharclever = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _fldchardefence = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper _fldchardescription = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _fldcharhealth = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _fldcharmove = null;
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _fldcharname = null;
public static anywheresoftware.b4j.objects.SliderWrapper _fldcharquick = null;
public static anywheresoftware.b4j.objects.SliderWrapper _fldcharstrong = null;
public static anywheresoftware.b4j.objects.SliderWrapper _fldcharmagic = null;
public static anywheresoftware.b4j.objects.LabelWrapper _lblpts = null;
public static anywheresoftware.b4j.objects.ChoiceBoxWrapper _skillchoicebox = null;
public static anywheresoftware.b4j.objects.LabelWrapper _lblskillpts = null;
public static anywheresoftware.b4j.objects.TableViewWrapper _tblskills = null;
public static net.bemperum.rpg.main._cellindex _currenteditablecell = null;
public static net.bemperum.rpg.gui_helpers _gui_helpers = null;
public static net.bemperum.rpg.odchar _odchar = null;
public static class _cellindex{
public boolean IsInitialized;
public int Row;
public int Column;
public void Initialize() {
IsInitialized = true;
Row = 0;
Column = 0;
}
@Override
		public String toString() {
			return BA.TypeToString(this, false);
		}}
public static String  _appstart(anywheresoftware.b4j.objects.Form _form1,String[] _args) throws Exception{
int _width = 0;
 //BA.debugLineNum = 31;BA.debugLine="Sub AppStart (Form1 As Form, Args() As String)";
 //BA.debugLineNum = 32;BA.debugLine="MainForm = Form1";
_mainform = _form1;
 //BA.debugLineNum = 33;BA.debugLine="MainForm.RootPane.LoadLayout(\"mainWindow\") 'Load";
_mainform.getRootPane().LoadLayout(ba,"mainWindow");
 //BA.debugLineNum = 34;BA.debugLine="MainForm.Show";
_mainform.Show();
 //BA.debugLineNum = 36;BA.debugLine="ConfigSliders";
_configsliders();
 //BA.debugLineNum = 37;BA.debugLine="calculateStats";
_calculatestats();
 //BA.debugLineNum = 38;BA.debugLine="LoadSkills";
_loadskills();
 //BA.debugLineNum = 40;BA.debugLine="currentEditableCell.Row = -1";
_currenteditablecell.Row = (int) (-1);
 //BA.debugLineNum = 42;BA.debugLine="tblSkills.SetColumnWidth(0, 80)";
_tblskills.SetColumnWidth((int) (0),80);
 //BA.debugLineNum = 43;BA.debugLine="tblSkills.SetColumnWidth(1, 80)";
_tblskills.SetColumnWidth((int) (1),80);
 //BA.debugLineNum = 44;BA.debugLine="tblSkills.SetColumnWidth(3, 60)";
_tblskills.SetColumnWidth((int) (3),60);
 //BA.debugLineNum = 45;BA.debugLine="Dim width As Int = tblSkills.Width";
_width = (int) (_tblskills.getWidth());
 //BA.debugLineNum = 46;BA.debugLine="tblSkills.SetColumnWidth(2, (width-80-80-60-5)) '";
_tblskills.SetColumnWidth((int) (2),(_width-80-80-60-5));
 //BA.debugLineNum = 47;BA.debugLine="lblSkillPTS.Text = \"6\" ' set the available skill";
_lblskillpts.setText("6");
 //BA.debugLineNum = 48;BA.debugLine="End Sub";
return "";
}
public static String  _calcpoints() throws Exception{
int _totalp = 0;
int _sum = 0;
int _currentpts = 0;
 //BA.debugLineNum = 201;BA.debugLine="Sub calcPoints";
 //BA.debugLineNum = 202;BA.debugLine="Dim totalP As Int = 6 ' Maximum 6 pts for ATTRIBU";
_totalp = (int) (6);
 //BA.debugLineNum = 203;BA.debugLine="Dim sum As Int";
_sum = 0;
 //BA.debugLineNum = 204;BA.debugLine="Dim currentPTS As Int";
_currentpts = 0;
 //BA.debugLineNum = 206;BA.debugLine="sum = (fldCharClever.Value + _ 		fldCharMagic.Val";
_sum = (int) ((_fldcharclever.getValue()+_fldcharmagic.getValue()+_fldcharquick.getValue()+_fldcharstrong.getValue()));
 //BA.debugLineNum = 211;BA.debugLine="currentPTS = (totalP - sum)";
_currentpts = (int) ((_totalp-_sum));
 //BA.debugLineNum = 213;BA.debugLine="If (currentPTS < 0) Or (sum > totalP) Then";
if ((_currentpts<0) || (_sum>_totalp)) { 
 //BA.debugLineNum = 214;BA.debugLine="lblPTS.TextColor = 	fx.Colors.Red";
_lblpts.setTextColor(_fx.Colors.Red);
 }else {
 //BA.debugLineNum = 216;BA.debugLine="lblPTS.TextColor = fx.Colors.Black";
_lblpts.setTextColor(_fx.Colors.Black);
 };
 //BA.debugLineNum = 218;BA.debugLine="lblPTS.Text = currentPTS";
_lblpts.setText(BA.NumberToString(_currentpts));
 //BA.debugLineNum = 219;BA.debugLine="End Sub";
return "";
}
public static String  _calculatestats() throws Exception{
 //BA.debugLineNum = 177;BA.debugLine="Sub calculateStats";
 //BA.debugLineNum = 178;BA.debugLine="fldCharHealth.Text = ODChar.calculateHealth(Floor";
_fldcharhealth.setText(BA.NumberToString(_odchar._calculatehealth((int) (anywheresoftware.b4a.keywords.Common.Floor(_fldcharstrong.getValue())))));
 //BA.debugLineNum = 179;BA.debugLine="fldCharDefence.Text = ODChar.calculateDefence( _";
_fldchardefence.setText(BA.NumberToString(_odchar._calculatedefence((int) (anywheresoftware.b4a.keywords.Common.Floor(_fldcharstrong.getValue())),(int) (anywheresoftware.b4a.keywords.Common.Floor(_fldcharquick.getValue())))));
 //BA.debugLineNum = 183;BA.debugLine="fldCharMove.Text = ODChar.calculateMove(Floor(fld";
_fldcharmove.setText(BA.NumberToString(_odchar._calculatemove((int) (anywheresoftware.b4a.keywords.Common.Floor(_fldcharquick.getValue())))));
 //BA.debugLineNum = 184;BA.debugLine="End Sub";
return "";
}
public static boolean  _checkfields() throws Exception{
 //BA.debugLineNum = 169;BA.debugLine="Sub CheckFields As Boolean";
 //BA.debugLineNum = 170;BA.debugLine="If(fldCharName.Text = \"\") Or (fldCharDescription.";
if (((_fldcharname.getText()).equals("")) || ((_fldchardescription.getText()).equals(""))) { 
 //BA.debugLineNum = 171;BA.debugLine="Return False";
if (true) return anywheresoftware.b4a.keywords.Common.False;
 }else {
 //BA.debugLineNum = 173;BA.debugLine="Return True";
if (true) return anywheresoftware.b4a.keywords.Common.True;
 };
 //BA.debugLineNum = 175;BA.debugLine="End Sub";
return false;
}
public static String  _clearandresetgui() throws Exception{
 //BA.debugLineNum = 186;BA.debugLine="Sub ClearAndResetGUI()";
 //BA.debugLineNum = 188;BA.debugLine="fldCharName.Text = \"\"";
_fldcharname.setText("");
 //BA.debugLineNum = 189;BA.debugLine="fldCharDescription.Text = \"\"";
_fldchardescription.setText("");
 //BA.debugLineNum = 191;BA.debugLine="fldCharClever.Value = 1";
_fldcharclever.setValue(1);
 //BA.debugLineNum = 192;BA.debugLine="fldCharMagic.Value = 0";
_fldcharmagic.setValue(0);
 //BA.debugLineNum = 193;BA.debugLine="fldCharQuick.Value = 1";
_fldcharquick.setValue(1);
 //BA.debugLineNum = 194;BA.debugLine="fldCharStrong.Value = 0";
_fldcharstrong.setValue(0);
 //BA.debugLineNum = 196;BA.debugLine="calculateStats";
_calculatestats();
 //BA.debugLineNum = 198;BA.debugLine="tblSkills.Items.Clear";
_tblskills.getItems().Clear();
 //BA.debugLineNum = 199;BA.debugLine="End Sub";
return "";
}
public static String  _configsliders() throws Exception{
anywheresoftware.b4j.objects.SliderWrapper[] _sliders = null;
anywheresoftware.b4j.objects.SliderWrapper _thisslider = null;
 //BA.debugLineNum = 50;BA.debugLine="Sub ConfigSliders()";
 //BA.debugLineNum = 54;BA.debugLine="Dim sliders() As Slider";
_sliders = new anywheresoftware.b4j.objects.SliderWrapper[(int) (0)];
{
int d0 = _sliders.length;
for (int i0 = 0;i0 < d0;i0++) {
_sliders[i0] = new anywheresoftware.b4j.objects.SliderWrapper();
}
}
;
 //BA.debugLineNum = 55;BA.debugLine="sliders = Array As Slider(fldCharStrong, fldCharQ";
_sliders = new anywheresoftware.b4j.objects.SliderWrapper[]{_fldcharstrong,_fldcharquick,_fldcharclever};
 //BA.debugLineNum = 56;BA.debugLine="For Each thisSlider As Slider In sliders";
final anywheresoftware.b4j.objects.SliderWrapper[] group3 = _sliders;
final int groupLen3 = group3.length;
for (int index3 = 0;index3 < groupLen3 ;index3++){
_thisslider = group3[index3];
 //BA.debugLineNum = 57;BA.debugLine="GUI_Helpers.SetSliderSticky(thisSlider, 1.0, 3.0";
_gui_helpers._setslidersticky(_thisslider,1.0,3.0,2.0);
 }
;
 //BA.debugLineNum = 59;BA.debugLine="GUI_Helpers.SetSliderSticky(fldCharMagic, 0.0, 3.";
_gui_helpers._setslidersticky(_fldcharmagic,0.0,3.0,0.0);
 //BA.debugLineNum = 60;BA.debugLine="End Sub";
return "";
}
public static String  _copytoclipboard() throws Exception{
String _completestring = "";
 //BA.debugLineNum = 92;BA.debugLine="Sub CopyToClipboard";
 //BA.debugLineNum = 94;BA.debugLine="Dim completeString As String";
_completestring = "";
 //BA.debugLineNum = 96;BA.debugLine="If CheckFields Then";
if (_checkfields()) { 
 //BA.debugLineNum = 98;BA.debugLine="completeString = \"Name: \" & fldCharName.Text & C";
_completestring = "Name: "+_fldcharname.getText()+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 99;BA.debugLine="completeString = completeString & \"Description:";
_completestring = _completestring+"Description: "+_fldchardescription.getText()+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 102;BA.debugLine="completeString = completeString & \"Strong: \" & f";
_completestring = _completestring+"Strong: "+BA.NumberToString(_fldcharstrong.getValue())+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 103;BA.debugLine="completeString = completeString & \"Quick: \" & fl";
_completestring = _completestring+"Quick: "+BA.NumberToString(_fldcharquick.getValue())+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 104;BA.debugLine="completeString = completeString & \"Clever: \" & f";
_completestring = _completestring+"Clever: "+BA.NumberToString(_fldcharclever.getValue())+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 107;BA.debugLine="completeString = completeString & \"Health: \" & f";
_completestring = _completestring+"Health: "+_fldcharhealth.getText()+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 108;BA.debugLine="completeString = completeString & \"Defence: \" &";
_completestring = _completestring+"Defence: "+_fldchardefence.getText()+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 109;BA.debugLine="completeString = completeString & \"Move: \" & fld";
_completestring = _completestring+"Move: "+_fldcharmove.getText()+anywheresoftware.b4a.keywords.Common.CRLF+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 112;BA.debugLine="completeString = completeString & \"SKILLS:\" & CR";
_completestring = _completestring+"SKILLS:"+anywheresoftware.b4a.keywords.Common.CRLF;
 //BA.debugLineNum = 113;BA.debugLine="completeString = completeString & getSkillsFromT";
_completestring = _completestring+_getskillsfromtable();
 //BA.debugLineNum = 116;BA.debugLine="fx.Clipboard.SetString(completeString)";
_fx.Clipboard.SetString(_completestring);
 }else {
 //BA.debugLineNum = 118;BA.debugLine="fx.Msgbox2(MainForm, _  					\"You need a name/de";
_fx.Msgbox2(_mainform,"You need a name/description","Incomplete Information","Okay","","",_fx.MSGBOX_INFORMATION);
 };
 //BA.debugLineNum = 126;BA.debugLine="End Sub";
return "";
}
public static anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper  _createitem(String _text,net.bemperum.rpg.main._cellindex _ci) throws Exception{
anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _tf = null;
 //BA.debugLineNum = 249;BA.debugLine="Sub CreateItem (text As String, ci As CellIndex) A";
 //BA.debugLineNum = 251;BA.debugLine="Dim tf As TextField";
_tf = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
 //BA.debugLineNum = 252;BA.debugLine="tf.Initialize(\"tf\")";
_tf.Initialize(ba,"tf");
 //BA.debugLineNum = 253;BA.debugLine="tf.Text = text";
_tf.setText(_text);
 //BA.debugLineNum = 254;BA.debugLine="tf.Tag = ci";
_tf.setTag((Object)(_ci));
 //BA.debugLineNum = 255;BA.debugLine="tf.Editable = False";
_tf.setEditable(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 256;BA.debugLine="Return tf";
if (true) return _tf;
 //BA.debugLineNum = 257;BA.debugLine="End Sub";
return null;
}
public static String  _endedit() throws Exception{
Object[] _row = null;
anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _tf = null;
 //BA.debugLineNum = 308;BA.debugLine="Sub EndEdit";
 //BA.debugLineNum = 309;BA.debugLine="If currentEditableCell.Row >= 0 Then";
if (_currenteditablecell.Row>=0) { 
 //BA.debugLineNum = 310;BA.debugLine="Dim row() As Object = tblSkills.Items.Get(curren";
_row = (Object[])(_tblskills.getItems().Get(_currenteditablecell.Row));
 //BA.debugLineNum = 311;BA.debugLine="Dim tf As TextField = row(currentEditableCell.Co";
_tf = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
_tf.setObject((javafx.scene.control.TextField)(_row[(int) (_currenteditablecell.Column-1)]));
 //BA.debugLineNum = 312;BA.debugLine="tf.Editable = False";
_tf.setEditable(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 313;BA.debugLine="tblSkills.RequestFocus";
_tblskills.RequestFocus();
 };
 //BA.debugLineNum = 315;BA.debugLine="currentEditableCell.Row = -1";
_currenteditablecell.Row = (int) (-1);
 //BA.debugLineNum = 316;BA.debugLine="End Sub";
return "";
}
public static String  _fldcharclever_valuechange(double _value) throws Exception{
 //BA.debugLineNum = 159;BA.debugLine="Sub fldCharClever_ValueChange (Value As Double)";
 //BA.debugLineNum = 160;BA.debugLine="sliders_ValueChanged(Value)";
_sliders_valuechanged(_value);
 //BA.debugLineNum = 161;BA.debugLine="calcPoints";
_calcpoints();
 //BA.debugLineNum = 162;BA.debugLine="End Sub";
return "";
}
public static String  _fldcharmagic_valuechange(double _value) throws Exception{
 //BA.debugLineNum = 164;BA.debugLine="Sub fldCharMagic_ValueChange (Value As Double)";
 //BA.debugLineNum = 165;BA.debugLine="sliders_ValueChanged(Value)";
_sliders_valuechanged(_value);
 //BA.debugLineNum = 166;BA.debugLine="calcPoints";
_calcpoints();
 //BA.debugLineNum = 167;BA.debugLine="End Sub";
return "";
}
public static String  _fldcharquick_valuechange(double _value) throws Exception{
 //BA.debugLineNum = 154;BA.debugLine="Sub fldCharQuick_ValueChange (Value As Double)";
 //BA.debugLineNum = 155;BA.debugLine="sliders_ValueChanged(Value)";
_sliders_valuechanged(_value);
 //BA.debugLineNum = 156;BA.debugLine="calcPoints";
_calcpoints();
 //BA.debugLineNum = 157;BA.debugLine="End Sub";
return "";
}
public static String  _fldcharstrong_valuechange(double _value) throws Exception{
 //BA.debugLineNum = 149;BA.debugLine="Sub fldCharStrong_ValueChange (Value As Double)";
 //BA.debugLineNum = 150;BA.debugLine="sliders_ValueChanged(Value)";
_sliders_valuechanged(_value);
 //BA.debugLineNum = 151;BA.debugLine="calcPoints";
_calcpoints();
 //BA.debugLineNum = 152;BA.debugLine="End Sub";
return "";
}
public static String  _getskillsfromtable() throws Exception{
String _skltxt = "";
Object[] _vals = null;
anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _tf = null;
int _i = 0;
 //BA.debugLineNum = 128;BA.debugLine="Sub getSkillsFromTable() As String";
 //BA.debugLineNum = 129;BA.debugLine="Dim sklTxt As String = \"\"";
_skltxt = "";
 //BA.debugLineNum = 130;BA.debugLine="Dim vals() As Object";
_vals = new Object[(int) (0)];
{
int d0 = _vals.length;
for (int i0 = 0;i0 < d0;i0++) {
_vals[i0] = new Object();
}
}
;
 //BA.debugLineNum = 131;BA.debugLine="Dim tf As TextField";
_tf = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
 //BA.debugLineNum = 132;BA.debugLine="If(tblSkills.Items.Size > 0) Then";
if ((_tblskills.getItems().getSize()>0)) { 
 //BA.debugLineNum = 133;BA.debugLine="For i = 0 To (tblSkills.Items.Size - 1)";
{
final int step5 = 1;
final int limit5 = (int) ((_tblskills.getItems().getSize()-1));
for (_i = (int) (0) ; (step5 > 0 && _i <= limit5) || (step5 < 0 && _i >= limit5); _i = ((int)(0 + _i + step5)) ) {
 //BA.debugLineNum = 134;BA.debugLine="vals = tblSkills.Items.Get(i)";
_vals = (Object[])(_tblskills.getItems().Get(_i));
 //BA.debugLineNum = 135;BA.debugLine="tf = vals(3)";
_tf.setObject((javafx.scene.control.TextField)(_vals[(int) (3)]));
 //BA.debugLineNum = 136;BA.debugLine="sklTxt = sklTxt & vals(0) & \" - (\" & vals(1) & \"";
_skltxt = _skltxt+BA.ObjectToString(_vals[(int) (0)])+" - ("+BA.ObjectToString(_vals[(int) (1)])+") - "+_tf.getText()+anywheresoftware.b4a.keywords.Common.CRLF;
 }
};
 };
 //BA.debugLineNum = 139;BA.debugLine="Return sklTxt";
if (true) return _skltxt;
 //BA.debugLineNum = 140;BA.debugLine="End Sub";
return "";
}
public static String  _loadskills() throws Exception{
anywheresoftware.b4a.objects.collections.List _content = null;
 //BA.debugLineNum = 241;BA.debugLine="Sub LoadSkills";
 //BA.debugLineNum = 242;BA.debugLine="Dim content As List = File.ReadList(File.DirAsset";
_content = new anywheresoftware.b4a.objects.collections.List();
_content = anywheresoftware.b4a.keywords.Common.File.ReadList(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"Skills.txt");
 //BA.debugLineNum = 243;BA.debugLine="skillChoiceBox.Items.Clear";
_skillchoicebox.getItems().Clear();
 //BA.debugLineNum = 244;BA.debugLine="skillChoiceBox.Items.AddAll(content)";
_skillchoicebox.getItems().AddAll(_content);
 //BA.debugLineNum = 245;BA.debugLine="End Sub";
return "";
}
public static String  _mnudeletetableitem_action() throws Exception{
int _currentitem = 0;
 //BA.debugLineNum = 320;BA.debugLine="Sub mnuDeleteTableItem_Action";
 //BA.debugLineNum = 323;BA.debugLine="Dim currentItem As Int";
_currentitem = 0;
 //BA.debugLineNum = 324;BA.debugLine="currentItem = tblSkills.SelectedRow";
_currentitem = _tblskills.getSelectedRow();
 //BA.debugLineNum = 325;BA.debugLine="If(currentItem > -1) Then";
if ((_currentitem>-1)) { 
 //BA.debugLineNum = 326;BA.debugLine="tblSkills.Items.RemoveAt(currentItem)";
_tblskills.getItems().RemoveAt(_currentitem);
 };
 //BA.debugLineNum = 328;BA.debugLine="End Sub";
return "";
}
public static String  _mnumain_action() throws Exception{
anywheresoftware.b4j.objects.MenuItemWrapper.ConcreteMenuItemWrapper _mi = null;
 //BA.debugLineNum = 62;BA.debugLine="Sub mnuMain_Action";
 //BA.debugLineNum = 66;BA.debugLine="Dim mi As MenuItem = Sender";
_mi = new anywheresoftware.b4j.objects.MenuItemWrapper.ConcreteMenuItemWrapper();
_mi.setObject((javafx.scene.control.MenuItem)(anywheresoftware.b4a.keywords.Common.Sender(ba)));
 //BA.debugLineNum = 68;BA.debugLine="Select mi.Text";
switch (BA.switchObjectToInt(_mi.getText(),"_New","_Open","_Save","_Quit","Clear","Randomize","Copy to clipboard","Help","About")) {
case 0: {
 break; }
case 1: {
 break; }
case 2: {
 break; }
case 3: {
 //BA.debugLineNum = 76;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
 break; }
case 4: {
 //BA.debugLineNum = 79;BA.debugLine="ClearAndResetGUI";
_clearandresetgui();
 break; }
case 5: {
 break; }
case 6: {
 //BA.debugLineNum = 84;BA.debugLine="CopyToClipboard";
_copytoclipboard();
 break; }
case 7: {
 break; }
case 8: {
 break; }
}
;
 //BA.debugLineNum = 90;BA.debugLine="End Sub";
return "";
}

private static boolean processGlobalsRun;
public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main._process_globals();
gui_helpers._process_globals();
odchar._process_globals();
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 7;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 9;BA.debugLine="Private MainForm As Form ' Our main window";
_mainform = new anywheresoftware.b4j.objects.Form();
 //BA.debugLineNum = 12;BA.debugLine="Private fldCharClever As Slider";
_fldcharclever = new anywheresoftware.b4j.objects.SliderWrapper();
 //BA.debugLineNum = 13;BA.debugLine="Private fldCharDefence As TextField";
_fldchardefence = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
 //BA.debugLineNum = 14;BA.debugLine="Private fldCharDescription As TextArea";
_fldchardescription = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper();
 //BA.debugLineNum = 15;BA.debugLine="Private fldCharHealth As TextField";
_fldcharhealth = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
 //BA.debugLineNum = 16;BA.debugLine="Private fldCharMove As TextField";
_fldcharmove = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
 //BA.debugLineNum = 17;BA.debugLine="Private fldCharName As TextField";
_fldcharname = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
 //BA.debugLineNum = 18;BA.debugLine="Private fldCharQuick As Slider";
_fldcharquick = new anywheresoftware.b4j.objects.SliderWrapper();
 //BA.debugLineNum = 19;BA.debugLine="Private fldCharStrong As Slider";
_fldcharstrong = new anywheresoftware.b4j.objects.SliderWrapper();
 //BA.debugLineNum = 20;BA.debugLine="Private fldCharMagic As Slider";
_fldcharmagic = new anywheresoftware.b4j.objects.SliderWrapper();
 //BA.debugLineNum = 21;BA.debugLine="Private lblPTS As Label";
_lblpts = new anywheresoftware.b4j.objects.LabelWrapper();
 //BA.debugLineNum = 22;BA.debugLine="Private skillChoiceBox As ChoiceBox";
_skillchoicebox = new anywheresoftware.b4j.objects.ChoiceBoxWrapper();
 //BA.debugLineNum = 23;BA.debugLine="Private lblSkillPTS As Label";
_lblskillpts = new anywheresoftware.b4j.objects.LabelWrapper();
 //BA.debugLineNum = 24;BA.debugLine="Private tblSkills As TableView";
_tblskills = new anywheresoftware.b4j.objects.TableViewWrapper();
 //BA.debugLineNum = 27;BA.debugLine="Type CellIndex (Row As Int, Column As Int)";
;
 //BA.debugLineNum = 28;BA.debugLine="Private currentEditableCell As CellIndex";
_currenteditablecell = new net.bemperum.rpg.main._cellindex();
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _skillchoicebox_selectedindexchanged(int _index,Object _value) throws Exception{
int _skl_std_value = 0;
String _thistxt = "";
net.bemperum.rpg.main._cellindex _ci = null;
anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _lbl = null;
Object[] _row = null;
String[] _currententry = null;
 //BA.debugLineNum = 221;BA.debugLine="Sub skillChoiceBox_SelectedIndexChanged(Index As I";
 //BA.debugLineNum = 222;BA.debugLine="Dim SKL_STD_VAlUE As Int = 1";
_skl_std_value = (int) (1);
 //BA.debugLineNum = 223;BA.debugLine="Dim thisTxt As String";
_thistxt = "";
 //BA.debugLineNum = 224;BA.debugLine="Dim ci As CellIndex";
_ci = new net.bemperum.rpg.main._cellindex();
 //BA.debugLineNum = 225;BA.debugLine="Dim lbl As TextField";
_lbl = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
 //BA.debugLineNum = 226;BA.debugLine="Dim row(4) As Object";
_row = new Object[(int) (4)];
{
int d0 = _row.length;
for (int i0 = 0;i0 < d0;i0++) {
_row[i0] = new Object();
}
}
;
 //BA.debugLineNum = 228;BA.debugLine="thisTxt = Value";
_thistxt = BA.ObjectToString(_value);
 //BA.debugLineNum = 229;BA.debugLine="Dim currentEntry() As String = Regex.Split(\";\", t";
_currententry = anywheresoftware.b4a.keywords.Common.Regex.Split(";",_thistxt);
 //BA.debugLineNum = 231;BA.debugLine="ci.Column = 4";
_ci.Column = (int) (4);
 //BA.debugLineNum = 232;BA.debugLine="ci.Row = tblSkills.Items.Size";
_ci.Row = _tblskills.getItems().getSize();
 //BA.debugLineNum = 233;BA.debugLine="row(0) = currentEntry(0)";
_row[(int) (0)] = (Object)(_currententry[(int) (0)]);
 //BA.debugLineNum = 234;BA.debugLine="row(1) = currentEntry(1)";
_row[(int) (1)] = (Object)(_currententry[(int) (1)]);
 //BA.debugLineNum = 235;BA.debugLine="row(2) = currentEntry(2)";
_row[(int) (2)] = (Object)(_currententry[(int) (2)]);
 //BA.debugLineNum = 236;BA.debugLine="lbl = CreateItem(SKL_STD_VAlUE, ci)";
_lbl = _createitem(BA.NumberToString(_skl_std_value),_ci);
 //BA.debugLineNum = 237;BA.debugLine="row(3) = lbl";
_row[(int) (3)] = (Object)(_lbl.getObject());
 //BA.debugLineNum = 238;BA.debugLine="tblSkills.Items.Add(row)";
_tblskills.getItems().Add((Object)(_row));
 //BA.debugLineNum = 239;BA.debugLine="End Sub";
return "";
}
public static String  _sliders_valuechanged(double _value) throws Exception{
 //BA.debugLineNum = 142;BA.debugLine="Sub sliders_ValueChanged(Value As Double)";
 //BA.debugLineNum = 145;BA.debugLine="calculateStats";
_calculatestats();
 //BA.debugLineNum = 146;BA.debugLine="calcPoints";
_calcpoints();
 //BA.debugLineNum = 147;BA.debugLine="End Sub";
return "";
}
public static String  _startedit(anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _tf) throws Exception{
 //BA.debugLineNum = 302;BA.debugLine="Sub StartEdit (tf As TextField)";
 //BA.debugLineNum = 303;BA.debugLine="tf.RequestFocus";
_tf.RequestFocus();
 //BA.debugLineNum = 304;BA.debugLine="tf.Editable = True";
_tf.setEditable(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 305;BA.debugLine="tf.SelectAll";
_tf.SelectAll();
 //BA.debugLineNum = 306;BA.debugLine="End Sub";
return "";
}
public static String  _tf_action() throws Exception{
anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _tf = null;
String _cval = "";
 //BA.debugLineNum = 273;BA.debugLine="Sub tf_Action";
 //BA.debugLineNum = 274;BA.debugLine="Dim tf As TextField = Sender";
_tf = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
_tf.setObject((javafx.scene.control.TextField)(anywheresoftware.b4a.keywords.Common.Sender(ba)));
 //BA.debugLineNum = 275;BA.debugLine="Dim cVal As String = tf.Text";
_cval = _tf.getText();
 //BA.debugLineNum = 278;BA.debugLine="If(IsNumber(cVal)) Then";
if ((anywheresoftware.b4a.keywords.Common.IsNumber(_cval))) { 
 //BA.debugLineNum = 279;BA.debugLine="If(cVal < 1) Or (cVal > 3) Then";
if (((double)(Double.parseDouble(_cval))<1) || ((double)(Double.parseDouble(_cval))>3)) { 
 //BA.debugLineNum = 280;BA.debugLine="fx.Msgbox2(MainForm, _ 						\"Your input must b";
_fx.Msgbox2(_mainform,"Your input must be between 1 and 3 please...","Input Error","Okay, got it!","","",_fx.MSGBOX_INFORMATION);
 }else {
 };
 }else {
 //BA.debugLineNum = 291;BA.debugLine="fx.Msgbox2(MainForm, _ 					\"Your input is not a";
_fx.Msgbox2(_mainform,"Your input is not a number between 1 and 3.","Format Error","Okay, got it!","","",_fx.MSGBOX_ERROR);
 };
 //BA.debugLineNum = 299;BA.debugLine="EndEdit";
_endedit();
 //BA.debugLineNum = 300;BA.debugLine="End Sub";
return "";
}
public static String  _tf_mouseclicked(anywheresoftware.b4j.objects.NodeWrapper.MouseEventWrapper _eventdata) throws Exception{
anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper _tf = null;
net.bemperum.rpg.main._cellindex _ci = null;
 //BA.debugLineNum = 259;BA.debugLine="Sub tf_MouseClicked (EventData As MouseEvent)";
 //BA.debugLineNum = 260;BA.debugLine="If EventData.ClickCount = 2 Then";
if (_eventdata.getClickCount()==2) { 
 //BA.debugLineNum = 261;BA.debugLine="Dim tf As TextField = Sender";
_tf = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextFieldWrapper();
_tf.setObject((javafx.scene.control.TextField)(anywheresoftware.b4a.keywords.Common.Sender(ba)));
 //BA.debugLineNum = 262;BA.debugLine="Dim ci As CellIndex = tf.Tag";
_ci = (net.bemperum.rpg.main._cellindex)(_tf.getTag());
 //BA.debugLineNum = 263;BA.debugLine="If currentEditableCell.Column <>ci.Column Or cur";
if (_currenteditablecell.Column!=_ci.Column || _currenteditablecell.Row!=_ci.Row) { 
 //BA.debugLineNum = 264;BA.debugLine="EndEdit";
_endedit();
 };
 //BA.debugLineNum = 266;BA.debugLine="currentEditableCell.Column = ci.Column";
_currenteditablecell.Column = _ci.Column;
 //BA.debugLineNum = 267;BA.debugLine="currentEditableCell.Row = ci.Row";
_currenteditablecell.Row = _ci.Row;
 //BA.debugLineNum = 268;BA.debugLine="tblSkills.SelectedRow = ci.Row";
_tblskills.setSelectedRow(_ci.Row);
 //BA.debugLineNum = 269;BA.debugLine="CallSubDelayed2(Me, \"StartEdit\", tf)";
anywheresoftware.b4a.keywords.Common.CallSubDelayed2(ba,main.getObject(),"StartEdit",(Object)(_tf));
 };
 //BA.debugLineNum = 271;BA.debugLine="End Sub";
return "";
}
}
