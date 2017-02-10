Type=StaticCode
Version=4.7
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Static code module
Sub Process_Globals
	Private fx As JFX
End Sub

Sub calculateMove (quick As Int) As Int
	Dim move As Int
	move = Floor(quick) * 10
	Return move
End Sub
	
Sub calculateHealth (strong As Int) As Int
	Dim health As Int
	health = Floor(strong) * 3
	Return health
End Sub

Sub calculateDefence (strong As Int, quick As Int) As Int
	Dim defence As Int
	defence = Max(Floor(strong), Floor(quick)) * 3
	Return defence
End Sub