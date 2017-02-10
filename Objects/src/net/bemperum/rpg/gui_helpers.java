package net.bemperum.rpg;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class gui_helpers extends Object{
public static gui_helpers mostCurrent = new gui_helpers();

public static BA ba;
static {
		ba = new  anywheresoftware.b4j.objects.FxBA("net.bemperum.rpg", "net.bemperum.rpg.gui_helpers", null);
		ba.loadHtSubs(gui_helpers.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "net.bemperum.rpg.gui_helpers", ba);
		}
	}
    public static Class<?> getObject() {
		return gui_helpers.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.objects.JFX _fx = null;
public static net.bemperum.rpg.main _main = null;
public static net.bemperum.rpg.odchar _odchar = null;
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 4;BA.debugLine="End Sub";
return "";
}
public static String  _setslidersticky(anywheresoftware.b4j.objects.SliderWrapper _thisslider,double _thismin,double _thismax,double _currentvalue) throws Exception{
anywheresoftware.b4j.object.JavaObject _sli = null;
 //BA.debugLineNum = 6;BA.debugLine="Sub SetSliderSticky(thisSlider As Slider, thisMin";
 //BA.debugLineNum = 7;BA.debugLine="Dim sli As JavaObject";
_sli = new anywheresoftware.b4j.object.JavaObject();
 //BA.debugLineNum = 8;BA.debugLine="sli = thisSlider";
_sli.setObject((java.lang.Object)(_thisslider.getObject()));
 //BA.debugLineNum = 9;BA.debugLine="sli.RunMethod(\"setMin\", Array As Object(thisMin))";
_sli.RunMethod("setMin",new Object[]{(Object)(_thismin)});
 //BA.debugLineNum = 10;BA.debugLine="sli.RunMethod(\"setMax\", Array As Object(thisMax))";
_sli.RunMethod("setMax",new Object[]{(Object)(_thismax)});
 //BA.debugLineNum = 11;BA.debugLine="sli.RunMethod(\"setValue\", Array As Object(current";
_sli.RunMethod("setValue",new Object[]{(Object)(_currentvalue)});
 //BA.debugLineNum = 12;BA.debugLine="sli.RunMethod(\"setShowTickLabels\", Array As Objec";
_sli.RunMethod("setShowTickLabels",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.True)});
 //BA.debugLineNum = 13;BA.debugLine="sli.RunMethod(\"setShowTickMarks\", Array As Object";
_sli.RunMethod("setShowTickMarks",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.True)});
 //BA.debugLineNum = 14;BA.debugLine="sli.RunMethod(\"setMajorTickUnit\", Array As Object";
_sli.RunMethod("setMajorTickUnit",new Object[]{(Object)(1.0)});
 //BA.debugLineNum = 15;BA.debugLine="sli.RunMethod(\"setMinorTickCount\", Array As Objec";
_sli.RunMethod("setMinorTickCount",new Object[]{(Object)(0)});
 //BA.debugLineNum = 16;BA.debugLine="sli.RunMethod(\"setSnapToTicks\", Array As Object(T";
_sli.RunMethod("setSnapToTicks",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.True)});
 //BA.debugLineNum = 17;BA.debugLine="End Sub";
return "";
}
}
