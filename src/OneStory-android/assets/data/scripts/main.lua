


function init()

end


function setup()

end


function main()
	out.println("Starting")	
	
	macha = characters.create("macha")
	out.println("macha created")
	novel.t("???")
	novel.p("Hello you there !")
	out.println("Hello")
	novel.p("I'm Macha, and i'll be your guide through this demo application.")
	macha.appear("happy",0,0)
	macha.say("The goal of this demo app is to show you the possibilities offered by the \"One Story Engine\".")
	macha.anim("happy",3)
	macha.say("First of all, have you ever played a visual novel before ?")
	
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
	
	
end