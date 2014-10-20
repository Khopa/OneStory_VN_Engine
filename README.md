OneStory_VN_Engine
==================

**This is unfinished and can't really be used, it was also based on a libgdx version prior to 1.0 and will need some fixes to work with the 1.0+ versions**

This is a visual novel "engine" for PC and Android written in Java with LibGdx, scripts for the novel are written in Lua.


Features :
----------

- Main Menu & Options Menu
- Visual Novel Scripting in Lua through Luaj
- Visual Novel Characters & Animation
- Basic StringManager for LibGDX (translations)
- Scene transitions

Example Lua Script :
--------------------

```lua
function main()
	
	-- Print to java console 
	out.println("Starting")	
	
	-- Load a character (must be defined in assets/data/characters.xml)
	macha = characters.create("macha")
	out.println("macha created")
	
	-- Set manually the talking character
	novel.t("???")
	
	-- Set manually a sentence
	novel.p("Hello you there !")
	out.println("Hello")
	
	novel.p("I'm Macha, and i'll be your guide through this demo application.")
	
	-- Make a character appear with an animation
	macha.appear("happy",0,0)
	-- Make a character talk 
	macha.say("The goal of this demo app is to show you the possibilities offered by the \"One Story Engine\".")
	-- Change animation
	macha.anim("happy",3)
	
	macha.say("First of all, have you ever played a visual novel before ?")
	
	-- Choices
	playedVisualNovel = novel.choice("First of all, have you ever played a visual novel before ?", "Yes|No|Of course")
	
	if playedVisualNovel == "No" then
		macha.anim("normal",999)
		macha.say("Well ... Right now, you are playing a visual novel !")
	else
		macha.anim("happy",8)
		macha.say("That's super cool ! So you probably downloaded this app because you are planning to write a visual novel ?")
		macha.anim("happy",8)
		macha.say("I have nothing to teach you then.")
	end
	
	-- Any lua code can also be written, but java binding must be written in order to interact with the engine
	
end
```

*The project doesn't have a clean build script  (Maven or Gradle)
Importing in Eclipse/Intellij and linking the projects and configuring the build path manually is the only way to go.*

<a href="url"><img src="https://raw.github.com/Khopa/OneStory_VN_Engine/master/os1.png" align="left" height="350"></a>
<a href="url"><img src="https://raw.github.com/Khopa/OneStory_VN_Engine/master/os1.png" align="left" height="350"></a>
<a href="url"><img src="https://raw.github.com/Khopa/OneStory_VN_Engine/master/os1.png" align="left" height="350"></a>

![alt tag](https://raw.github.com/Khopa/OneStory_VN_Engine/master/os1.png)
![alt tag](https://raw.github.com/Khopa/OneStory_VN_Engine/master/os2.png)
![alt tag](https://raw.github.com/Khopa/OneStory_VN_Engine/master/os3.png)
![alt tag](https://raw.github.com/Khopa/OneStory_VN_Engine/master/os4.png)





