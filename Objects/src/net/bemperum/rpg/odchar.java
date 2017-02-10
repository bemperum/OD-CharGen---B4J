package net.bemperum.rpg;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.debug.*;

public class odchar extends Object{
public static odchar mostCurrent = new odchar();

public static BA ba;
static {
		ba = new  anywheresoftware.b4j.objects.FxBA("net.bemperum.rpg", "net.bemperum.rpg.odchar", null);
		ba.loadHtSubs(odchar.class);
        if (ba.getClass().getName().endsWith("ShellBA")) {
			
			ba.raiseEvent2(null, true, "SHELL", false);
			ba.raiseEvent2(null, true, "CREATE", true, "net.bemperum.rpg.odchar", ba);
		}
	}
    public static Class<?> getObject() {
		return odchar.class;
	}

 public static anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4j.objects.JFX _fx = null;
public static net.bemperum.rpg.main _main = null;
public static net.bemperum.rpg.gui_helpers _gui_helpers = null;
public static int  _calculatedefence(int _strong,int _quick) throws Exception{
int _defence = 0;
 //BA.debugLineNum = 18;BA.debugLine="Sub calculateDefence (strong As Int, quick As Int)";
 //BA.debugLineNum = 19;BA.debugLine="Dim defence As Int";
_defence = 0;
 //BA.debugLineNum = 20;BA.debugLine="defence = Max(Floor(strong), Floor(quick)) * 3";
_defence = (int) (anywheresoftware.b4a.keywords.Common.Max(anywheresoftware.b4a.keywords.Common.Floor(_strong),anywheresoftware.b4a.keywords.Common.Floor(_quick))*3);
 //BA.debugLineNum = 21;BA.debugLine="Return defence";
if (true) return _defence;
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return 0;
}
public static int  _calculatehealth(int _strong) throws Exception{
int _health = 0;
 //BA.debugLineNum = 12;BA.debugLine="Sub calculateHealth (strong As Int) As Int";
 //BA.debugLineNum = 13;BA.debugLine="Dim health As Int";
_health = 0;
 //BA.debugLineNum = 14;BA.debugLine="health = Floor(strong) * 3";
_health = (int) (anywheresoftware.b4a.keywords.Common.Floor(_strong)*3);
 //BA.debugLineNum = 15;BA.debugLine="Return health";
if (true) return _health;
 //BA.debugLineNum = 16;BA.debugLine="End Sub";
return 0;
}
public static int  _calculatemove(int _quick) throws Exception{
int _move = 0;
 //BA.debugLineNum = 6;BA.debugLine="Sub calculateMove (quick As Int) As Int";
 //BA.debugLineNum = 7;BA.debugLine="Dim move As Int";
_move = 0;
 //BA.debugLineNum = 8;BA.debugLine="move = Floor(quick) * 10";
_move = (int) (anywheresoftware.b4a.keywords.Common.Floor(_quick)*10);
 //BA.debugLineNum = 9;BA.debugLine="Return move";
if (true) return _move;
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return 0;
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 3;BA.debugLine="Private fx As JFX";
_fx = new anywheresoftware.b4j.objects.JFX();
 //BA.debugLineNum = 4;BA.debugLine="End Sub";
return "";
}
}
