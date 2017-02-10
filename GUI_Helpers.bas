Type=StaticCode
Version=4.7
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Static code module
Sub Process_Globals
	Private fx As JFX
End Sub

Sub SetSliderSticky(thisSlider As Slider, thisMin As Double, thisMax As Double, currentValue As Double)
	Dim sli As JavaObject
	sli = thisSlider
	sli.RunMethod("setMin", Array As Object(thisMin))
	sli.RunMethod("setMax", Array As Object(thisMax))
	sli.RunMethod("setValue", Array As Object(currentValue))
	sli.RunMethod("setShowTickLabels", Array As Object(True))
	sli.RunMethod("setShowTickMarks", Array As Object(True))
	sli.RunMethod("setMajorTickUnit", Array As Object(1.0))
	sli.RunMethod("setMinorTickCount", Array As Object(0))
	sli.RunMethod("setSnapToTicks", Array As Object(True))
End Sub
