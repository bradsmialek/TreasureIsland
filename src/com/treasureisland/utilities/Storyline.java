package com.treasureisland.utilities;

import java.util.ArrayList;

/**
 * Created by bradsmialek on Wed - 8/5/20 @ 4:10 AM
 * Story
 */
public class Storyline {

    private static ArrayList<String> bPearlMessages;
    private static ArrayList<String> bPearlClues;

    private static ArrayList<String> rum1messages;
    private static ArrayList<String> rum2messages;
    private static ArrayList<String> rum3messages;
    private static ArrayList<String> rum4messages;
    private static ArrayList<String> rum1Clues;



    public static void createStoryline(){
        bPearlMessages = new ArrayList<>();
        bPearlMessages.add("black pearl 1  message 1vknsldvgknsldknvlklksndflksnflbknsflkbnsfvnsdlkn gvksdn glksdnlkkk"); //91 characters across
        bPearlMessages.add("black pearl 1  message 2");
        bPearlMessages.add("black pearl 1  message 3");
        bPearlMessages.add("black pearl 1  message 4");
        bPearlMessages.add("black pearl 1  message 5");
        bPearlMessages.add("black pearl 1  message 6");

        bPearlClues = new ArrayList<>();
        bPearlClues.add("black pearl Clue 1  message 1vknsldvgknsldknvlklksndflksnflbknsflkbnsfvnsdlkn gvksdn glksdnlkkk"); //91 characters across
        bPearlClues.add("black pearl Clue 1  message 2");
        bPearlClues.add("black pearl Clue 1  message 3");
        bPearlClues.add("black pearl Clue 1  message 4");
        bPearlClues.add("black pearl Clue 1  message 5");
        bPearlClues.add("black pearl Clue 1  message 6");


        rum1messages = new ArrayList<>();
        rum1messages.add("rum 1  message 1");
        rum1messages.add("rum 1  message 2");
        rum1messages.add("rum 1  message 3");
        rum1messages.add("rum 1  message 4");
        rum1messages.add("rum 1  message 5");
        rum1messages.add("rum 1  message 6");

        rum1Clues = new ArrayList<>();
        rum1Clues.add("rum1 Clue 1  message 1vknsldvgknsldknvlklksndflksnflbknsflkbnsfvnsdlkn gvksdn glksdnlkkk"); //91 characters across
        rum1Clues.add("rum1 Clue 1  message 2");
        rum1Clues.add("rum1 Clue 1  message 3");
        rum1Clues.add("rum1 Clue 1  message 4");
        rum1Clues.add("rum1 Clue 1  message 5");
        rum1Clues.add("rum1 Clue 1  message 6");


        rum2messages = new ArrayList<>();
        rum2messages.add("rum 2  message 1");
        rum2messages.add("rum 2  message 2");
        rum2messages.add("rum 2  message 3");
        rum2messages.add("rum 2  message 4");
        rum2messages.add("rum 2  message 5");
        rum2messages.add("rum 2  message 6");

        rum3messages = new ArrayList<>();
        rum3messages.add("rum 3  message 1");
        rum3messages.add("rum 3  message 2");
        rum3messages.add("rum 3  message 3");
        rum3messages.add("rum 3  message 4");
        rum3messages.add("rum 3  message 5");
        rum3messages.add("rum 3  message 6");

        rum4messages = new ArrayList<>();
        rum4messages.add("rum 4  message 1");
        rum4messages.add("rum 4  message 2");
        rum4messages.add("rum 4  message 3");
        rum4messages.add("rum 4  message 4");
        rum4messages.add("rum 4  message 5");
        rum4messages.add("rum 4  message 6");

    }



    //GETTERS

    public static ArrayList<String> getbPearlMessages() {
        System.out.println("GETTING Pearl MESSAGES");
        return bPearlMessages;
    }

    public static ArrayList<String> getRum1messages() {
        System.out.println("GETTING Rum 1 MESSAGES");
        return rum1messages;
    }

    public static ArrayList<String> getRum2messages() {
        System.out.println("GETTING Rum 2 MESSAGES");
        return rum2messages;
    }

    public static ArrayList<String> getRum3messages() {
        System.out.println("GETTING Rum 3 MESSAGES");
        return rum3messages;
    }

    public static ArrayList<String> getRum4messages() {
        System.out.println("GETTING Rum 4 MESSAGES");
        return rum4messages;
    }

    //GETTERS for Clues
    public static ArrayList<String> getbPearlClues() {
        return bPearlClues;
    }

    public static ArrayList<String> getRum1Clues() {
        return rum1Clues;
    }





//    private static ArrayList<String> messages;
//    private static ArrayList<String> messages;
//    private static ArrayList<String> messages;
//    private static ArrayList<String> messages;
//
//    private static ArrayList<String> messages;
//    private static ArrayList<String> messages;
//    private static ArrayList<String> messages;
//    private static ArrayList<String> messages;
//
//    private static ArrayList<String> messages;
//    private static ArrayList<String> messages;
//    private static ArrayList<String> messages;
//    private static ArrayList<String> messages;
//
//    private static ArrayList<String> messages;
//    private static ArrayList<String> messages;
//    private static ArrayList<String> messages;
//    private static ArrayList<String> messages;


}



/**
 * ISLANDS- Storyline Reference
 *
 * 1) Rum Runner Isle -- key
 * N -Rum Dist
 *     -talk store manager
 *     -look cask gives coins
 *     -inves  master brewer . envelope to great joe .  got map
 *     - clues system ??
 *     - exits to "crossroads" area
 *     - South - Crimson Beach
 *
 * S-Crimson Beach
 *     - jojo - room 999
 *     - look  , investigate - reveals story line
 *     - clue ? How's th' cabin number Jojo said t' look aft?
 *     - exit glitchy?
 *
 * E - Abandoned dist -
 *     - ghost
 *     -  look - distilling stills  this one is death trap . -50 DEATH
 *     - drink  key given
 *     - clue ??
 *
 * W - Sugara Cane Field   - key
 *     - introduces vendor as option?
 *     - need code to talk .  2x go away . Enter 9999
 *     -look water well - coins given .   NOthing was found CM ??
 *     -inves . scarecrow . gives key
 *     - vendor  cant buy
 *     - clue ??  lastOneDigitOff
 *
 * can leave island after getting cane shard, but not key??  logic ??
 *
 *
 *
 * 2) Port Royal -- key
 * N - Royal lodge
 *     - talk rm101 nothing found
 *     -special room  rm 999 found .  found small map
 *     - invest .  attempt to steal key .
 *     - no clue ...  doesn't tell us there is no clue - fix?
 * S-Ship graveyard
 *     - legend "High tide" ship -  found clue in journal about lost letter in lounge
 *     -look  took small ship??
 *     - invest .   gives coins
 *     - no clues
 * E-Sunset Restaurant
 *     - talk .  given sealed letter with bill
 *     -look . nothing
 *     -investigating
 *         -it revealed a paper underneath the sofa.
 *         -- It had a list of 5 things. Three keys with a drawing of them, a jewel
 *             drawing with a description and fourth one mentioned a map for II!
 *         - jumped by johns gang .  -takes health away
 *     -clue  no clue
 * W - Tiki lounge
 *     -talk  no code no talk, hint...  side quest to talk to npc at ship graveyard
 *     -look . flirts and gets nothing . CAllie?
 *     -invest  Sam- poker game - gets key for treasure island
 *     -clue . wierd question about name of ship
 *      -vendor
 *
 * Key is given and we can leave island
 * takes us to ship battle
 * takes us to Isla Cruces , no choice
 *
 * 3) Isla Cruces  -- find emerald
 * N- Church
 *      -talk  father joseph .  got goblet with emerald
 *     -look  nothing
 *     -invest . praying -- nothing
 *     -clue none
 *
 * exit makes us leave the island ??  Shoulg be able to go in a direction
 * no key
 * took us straight to next island
 *
 * S- Double cross tavern
 *      -talk carlos . nothing
 *     -look . basement nothing
 *     -invest roof deck . coins
 *     -clue none
 *      -vendor none
 *
 * E- Saints lodge
 *      -talk lounge  found note for items needed . jumped by johns gang . loses health
 *     -look room jumped again by john .  loses health
 *     -invest   john wacks him .  dead
 *     -clue none
 *      -vendor none
 *
 * W- Southend Beach
 *      -talk  surrender stolen item??
 *     -look says to Visit Sail High ship company
 *     -invest chat with grandma
 *     -clue give  up emerald?
 *      -vendor . doesn't work
 *
 * Note-
 * treasures needed to acces island .  how many ?
 *     -emerald
 *     -3keys
 *     -map
 *
 * gets emerald
 * battle scene
 * to next island - no choice
 *
 *
 * 4) Isla de Muerta   key
 * N- Abandodned house on hill
 *     -talk .  to room with nothing??  no talking
 *     -look . attic with curved key?  unlocks door   found gem
 *     -invest . room dead body .  finds key -not the right one
 *     -clue none
 *      -vendor none
 *
 * S-Graveyard
 *     -talk caretakers quarters ..  person hits chara .   took health damage
 *     -look tombstone . found nothing
 *     -invest pushes over tombstone found coins
 *     -clue none
 *      -vendor none
 *
 * E-Dusk till Dawn salloon
 *     -talk .  isabella .  go talk to john
 *     -look wine cellar . nothing
 *     -invest  fights john  gets key for next island
 *     -clue none
 *      -vendor none
 *
 * takes us to battle
 * then takes us to monestary give up gem... get box with key for treasures
 *
 * W- PawPaw Beach
 *     -talk   prints alll storyline .     slimjim chat nothing
 *     -look
 *     -invest
 *     -clue
 *      -vendor
 */


// TEXT
//Rum Island
//
//	1) Rum distillery
//            RDStart
//            a) Talked with the store house owner.
//            -- I applied for the position for store manager, to gain access to the property.
//            -- I checked the left corner of the store house as soon as I got a chance.
//            -- There was a nothing unusual about the place other than the small patch on the wall,
//            like it was fixed.
//            -- I poked at the patch and it caved in a little bit. I looked inside and found . . .
//            -- Nothing!
//            RDEnd
//            UCStart
//            b) Under the cask marked 9999.
//            -- I am sure I will find something interesting there. I am sure of it.
//            -- I looked under the cask as soon as I got the chance and I found . . .
//            -- A snake!!
//            UCEnd
//            OCStart
//            c) At the bottom of the open cask by the main door.
//        -- I don't even remember as to how I got this clue!
//        -- But I can't ignore any clues. This treasure hunting is not easy.
//        -- As soon as I got the chance, I inconspicuously got to the main the door.
//        -- I checked the open cask and I could not see anything.
//        -- I put my hand into the cask to check the bottom of the cask with murky smelly liquid!
//        -- I felt something at the bottom of cask, I pulled it out . . .
//        -- It was a small sack of coins!
//
//        OCEnd
//        MBStart
//        d) Ask master brewer for the Sunshine Rum sample.
//        -- This is the first thing I did, went straight to the master brewer.
//        -- I asked him " Can I get a sample of the Sunshine Rum"
//        -- MB - "You need what!" he replied with little surprised look on his face.
//        -- I repeated, can have some Sunshine rum?
//        -- MB grumbled something under his breath and disappeared for 10- 15 minutes,leaving me confused.
//        -- Finally he came back, gave me a clear looking liquid in a shot glass and asked me to drink up!
//        -- I looked at the shot glass and then back at MB, he was still staring at me!
//        -- I thought, whatever and drank up. I glanced at MB after taking the shot and he was still straining at me.
//        -- I finally asked, "Is that it?"
//        -- He kept staring at me for little more.
//        -- Then he finally passed me a envelop and said "I don't know how you know Great Joe but he told me to give this to the person asking for Sunshine Rum."
//        -- Received an envelop with a map inside. This is what we were looking for. Clues to the next island.
//        MBEnd
//
//        2) Sugar cane field
//        WWStart
//        a) By the water well.
//        --Found a spot that looked like it had been dug sometime back.
//        --I dug around the same spot . . . .
//        -- and I found coins!
//
//        WWEnd
//        URStart
//        b) Under the big rock.
//        -- It took a day to scout the field, but I was able to find the biggest rock.
//        -- I didn't notice anything unusual around the bottom of this huge rock.
//        -- Should I look again?
//        -- I still found no sign of anything unusual near the bottom of rock but i didn't notice a small carving near the very bottom of the stone, an inch or so above the ground.
//        -- The carving looked like a scarecrow.
//        -- Found nothing else.
//        UREnd
//        SSStart
//        c) In the storage shed.
//        -- Luckily there is only one small storage shed.
//        -- It was filled with junk and didn't seem like it has been used in a while.
//        -- I started going through the junk and guess what I found. . .
//        -- Scorpion, in fact it found me!!
//        Health -5
//        SSEnd
//        SStart
//        d) Check the scarecrow.
//        -- There are 5 scarecrows I counted across the fields and I looked way different than the others.
//        -- My pirate sense tells me that the different one holds a secret.
//        -- Upon the close examining of the scarecrow I found a . . .
//        --  . . . section on a stick that can be pulled out. In it was . . .
//        -- A key!
//        SEnd
//
//        3) Abandoned Distillery in the North.
//        DSStart
//        a) By the distilling stills.
//        -- There are four of the stills and I am not sure where to begin.
//        -- I started with exploring around the stills and within walking few meters or so I found . . .
//        -- a weak spot on floor and I crashed to basement right through it!
//        -- Health -50
//        DSEnd
//        ORStart
//        b) In the manager's creepy old room.
//        -- The first thing I noticed is the big painting straight in front of the door.
//        -- Found a piece of paper with a title " Summon B" and instructions for summoning something!
//        OREnd
//        BGStart
//        c) Summon the brewers' ghost.
//        -- I guess that's what the paper I found was for.
//        -- I performed the instructions . . .
//        -- Nothing happens.
//        BGEnd
//        DRStart
//        d) Drink from rum crate by the big window to find the key.
//        -- All the bottles look like empty.
//        -- But there seems to be little bit rum of left in one of the bottle.
//        -- I took a sip from the bottle.
//        -- When I was about to put the bottle back I found . . .
//        -- Antique coin.
//        DREnd
//
//        4) Crimson Beach bar
//        CBStart
//        a) Ask bartender for the Darkest Storm cocktail.
//        -- It was early evening when I reached the bar.
//        -- I went straight to the bar and ordered "Darkest Storm cocktail"
//        -- I was hoping to get some sort of clue from the bartender after asking for the drink.
//        -- But instead I got a big glass of the tastiest drink ever.
//        CBEnd
//        JStart
//        b) Ask to speak with Jojo for info.
//        -- Jojo was an old friend and someone I can confide in.
//        -- I told him about my plans but the only information he had for me was . . .
//        -- To look out for a room somewhere on a different island and it has something to do with number 999.
//        JEnd
//        SJStart
//        c) Ask drunk Sam Jr.
//        -- I decided to have one more drink and started chatting with Sam Jr.
//        -- He a middle aged gentleman, who is a regular patron at the bar .
//        -- Talking with him was interesting but it revealed . . .
//        -- nothing.
//        SJEnd
//        PTStart
//        d) Search near the pair of palm trees.
//        -- There were lot of trees around the bar.
//        -- But there were only three which were in pairs.
//        -- I examined all three and found . . .
//        -- the bushes near those trees weren't only thick and bushy but also hiding . . .
//        -- Poisonous spiders!
//        health -10
//        PTEnd
//
//        Port Royal
//
//        1)Royal Lodge
//        R1Start
//        a) Room 101.
//        -- I have heard various rumours about this room.
//        -- I heard that there is a hidden map in this room
//        -- Searching this room for the next few hours revealed . . .
//        -- Nothing!
//        R1Stop
//        BRStart
//        b) Steal the key hung in the breakfast room.
//        -- While eating breakfast I noticed a key hung on the wall.
//        -- I was able to find out that it is an old key that has been on that wall for years.
//        -- I casually took of the key and examined it and then left it by my table.
//        -- After finishing up my food I pretended to accidentally pick up the key in my pocket and tried to leave but . . .
//        -- I got called out, I pretended it to be an accident and put the key back on the wall.
//        BRStop
//
//        c) By the water fountain.
//        -- It looked like a normal water fountain with a fish statue. People were sitting around it.
//        -- I spent about 2 hours near that water fountain to find anything special but . . .
//        --found nothing.
//        SRStart
//        d) Special room.
//        -- This lodge had a special room, room 999!
//        -- It seems like this room may hold some clues.
//        -- I spent the whole night looking for clues from this room.
//        -- by early morning a found . . .
//        -- another small map hidden within the bible.
//        SRStop
//
//        2) Ship Graveyard
//        SGStart
//        a) Biggest and most fragile ship.
//        -- This was an old and abandoned legendary ship "High Tide".
//        -- Exploring this I found a clue in journal . . .
//        --  . . about the meeting and a lost letter at the lounge.
//        SGStop
//        SBStart
//        b) The smallest boat.
//        --This boat looked to be in fixable shape.
//        -- Got a small boat for the main ship.
//        SBStop
//
//        BBDStart
//        c) Open the box by the dock.
//        -- This box looked old and worn down.
//        -- Exploring the box I found
//        -- coins
//        BBDStop
//        d)
//
//        3) Sunset Restaurant
//        RNDStart
//        a) Place special order of Rum and Drums.
//        -- I placed an order of "Rum and Drums", which was not listed on the menu.
//        -- Server did give a surprise look and didn't ask me anything else.
//        -- This was a special order of their special rum drink and jerk flavoured drumsticks.
//        -- That was all I was able to get out of the server as she ignored all my efforts to strike a conversation.
//        -- But with my bill came a sealed letter.
//        RNDStop
//        SLStart
//        b) Book the special lounge to search there.
//        -- I found out that they had a special lounge for meetings and such.
//        -- I booked it under the pretence to have a meeting with few friends.
//        -- Searching it revealed a paper underneath the sofa.
//        -- It had a list of 5 things. Three keys with a drawing of them, a jewel drawing with a description and fourth one mentioned a map for II!
//        SLStop
//        TFTStart
//
//        c) Find a clue near the only table for two.
//        -- This was the most bizarre clue I ever received.
//        -- While sitting there figuring about what sort of clue I can find here, I observed . . .
//        -- The cook would sit behind me occasionally and would write something in diary while talking out aloud.
//        -- He mentioned few words like "treasure", "Island", "key" which piked my interest.
//        -- I found out he hides his diary in pantry.
//        TFTStop
//        PStart
//        d) Sneak in and search the pantry.
//        -- I snuck in and I . .
//        -- got the cooks diary with useful info.
//        PStop
//
//        4) Tikki Lounge
//        SOStart
//        a) Ask Sophia (Hostess)
//        -- This place is full of amazing looking people!
//        -- Sophia was cool to chat with and told me about the cook at Sunset restaurant, who is . . .
//        -- . .obsessed with treasures. Got valuable info!
//        SOStop
//        KAStart
//        b) Ask Kayla  (Bartender)
//        -- Later on, in the evening I sat at bar and struck conversation with Kayla.
//        -- She provided me with more valuable information.
//        -- about Callie (the owner) having knowledge about treasure stuff.
//        KAStop
//        CAStart
//        c) Ask Callie  (Owner)
//        -- I tried to strike conversation with Callie but she was not falling to worldly charms!
//        -- I could tell that she was mad at me for flirting with other girls!
//        -- I got . . .
//        -- Nothing but a cold shoulder!
//        CAStop
//        SAMStart
//        d) Talk with drunk Sam (The sailor).
//        -- It felt like Sam was almost half way to the la la land.
//        -- But he was still able to hold conversation even though most of his words were slurred.
//        -- Good thing is that I am good at understanding slur.
//        -- We ended up playing some poker.
//        -- I ended up getting coins.
//        -- But, somehow my pirate a** felt bad and I retuned the money to Sam. But he insisted that I keep it.
//        -- As I was about to leave, Sam grabbed my hand and passed me . . .
//        -- a Key!
//        -- He then told me sit down and informed me that he appreciate my kindness and also that he knew who I was!
//        -- He knew my father and they both had a lot of adventures together. And he was able to figure out who I was while we were conversing but was not sure if I had my dad's amazing character.
//        -- Returning the money proved it. We spent rest of the evening talking about everything but the key.
//        -- Towards the end of the night, we were saying our good byes and he mentioned " This is one of the keys!" and left.
//        SAMStop
//
//        Isla DM
//
//        1) Abandoned house on the hill.
//        FLStart
//        a) Room with flickering light.
//        -- This room is in the front of the house.
//        -- The first thing you notice about this house is the flickering light inside of the room.
//        -- Inside the house, I found that the flickering light was because of tons of broken mirrors in the house reflecting light into that particular room. Pretty weird!
//        -- Searched the room for few hours and found . . .
//        --Nothing, other than shimmering lights.
//        FLStop
//        HPStart
//        b) Upstairs room with red hand prints on the door.
//        -- Blood, these hand prints are of blood. What happened here?
//        -- I was right about hand prints, as there was more dried of blood on floor.
//        -- The room also hit you square in the jaw with its awful and foul smell.
//        -- But I persisted and searched the room. I found a shirt dirty and with dried blood all over it. . .
//        -- but hidden underneath the collar was a small little key!
//        HPStop
//        WNStart
//        c) Bathroom with dripping water noise.
//        -- Mouldy, musty and slippery.
//        -- There is no way I am going in there.
//        -- Found nothing.
//        WNStop
//        DAStart
//        d) In the dark attic.
//        -- This is the last place I wanna be at.
//        -- I was able to find a candle in the kitchen and it came in real handy to search the attic.
//        -- Attic also had a very foul and decaying smell. I found . . .
//        -- A skeleton! For observation it seem like the person was crawling towards the north corner of the attic.
//        -- Examining the corner I found a key hole!
//        -- The curved key I found fit perfectly into the lock. Inside I  . . .
//        -- Found a gem!
//        DAStop
//
//        2) Graveyard
//        BTStart
//        a) Search near the grave with the biggest tombstone.
//        -- This Island keeps getting better and better.
//        -- The grave I was looking to find was pretty easy to find.
//        -- The dug the grave and found . . .
//        --Nothing!
//        -- In my frustration I pushed against the tombstone and it moved a little!
//        -- I pushed it a little more and it pushed out a small wooden box at the bottom of the tombstone.
//        -- I found . . .
//        -- coins
//        BTStop
//        STStart
//        b) By the grave with the smallest tombstone.
//        -- This was little harder to find.
//        -- I searched both the grave and the tombstone. I found . . .
//        -- Nothing! Other than a creepy sound of a muffled sigh when I uprooted the tombstone.
//        STStop
//        CQStart
//        c) Search the abandoned caretaker's quarters.
//        -- My acquaintance left me near caretaker's quarters.
//        -- I could hear ruffling noises from inside.
//        -- I entered the room which was pitch dark. I took few steps forward and . . .
//        -- Someone pushed me from the right and took off running.
//        -- Lost health
//        CQStop
//        PTStart
//        d) Dig up the grave of legendary pirate Tumtum.
//        --
//
//        PTStop
//
//        3) Dusk till Dawn Saloon
//        SAMSStart
//        a) Speak with drunk Sam Sr.
//        -- Talking with Sam Sr. didn't reveal much.
//        -- He was just talking about his son being a very good man and he is really proud of him.
//        -- Got nothing.
//        SAMSStop
//        WCStart
//        b) Check the wine cellar.
//        -- This was easy, their wine cellar is accessible to public. You pick you bottle and and pay at the counter. Futuristic!
//        -- But what could I possibly find here? after much observation and exploring around I found . . .
//        --  . . .out that the tip I received to check this place was a waste of time.
//        -- Got nothing.
//        WCStop
//        KJStart
//        c) Knock out John, to steal the key hanging from around his neck.
//        -- From the information I gathered, this is one of the keys that I need.
//        -- So I fought John and I got . . .
//        -- A key
//        -- Lost health
//        KJStop
//        FIStart
//        d) Flirt with Isabella to find out more information.
//        -- Once again my charm came to the rescue. Flirting revealed . . .
//        -- a guy named John could have more information for me.
//        FIStop
//        PPStart
//        4) Pawpaw beach park
//        a) Look for a clue near Pawpaw's statue.
//        -- Pawpaw was a local legend. He was a merchant and adventurer. He was also believed to be a treasure hunter.
//        -- It is also believed that he also has more information/key or I need.
//        -- I explored around the statue area and found . .
//        -- Nothing
//        PPStop
//        CGStart
//        b) Win the top prize labelled "Key" at the balloon shooting carnival game.
//        -- This could be a total waste. Local legend Pawpaw is supposed to have provided with an odd, big ornate key to the Carnival which run every Saturday and Sunday.
//        -- That key is displayed as a first prize and a very tough shooting game.
//        -- No one has won it yet, or should I say that no one has been interested in winning an ornamental key. But I have a hunch.
//        -- After trying and failing to get the key for weeks. I got . . .
//        -- A key, I finally got the key and became a little bit of local legend myself.
//        CGStop
//        SJStart
//        c) Win the hot-dog eating competition to beat Slimjaw. Slimjaw has some useful information.
//        -- This was not easy!
//        -- I tried to out  eat him, I tried it few times over the days and . .
//        --  . . . I couldn't win. But we became friends and he provided me with . .
//        -- Info to search Pawpaw museum.
//        SJStop
//        PMStart
//        d) Pawpaw beach park museum.
//        --Interesting museum, Pawpaw donated lot of stuff for this museum.
//        -- But I found out nothing interesting here.
//        PMStop
//
//        Isla c
//
//        1) Church
//        CStart
//        a) I got a hint that here is valuable treasure in the confession chamber.
//        -- I snuck in there to look for clues.
//        -- I searched but I found  . . .
//        -- . . . nothing!
//        CStop
//        AStart
//        b) Pray at the alter to ask god for help.
//        -- I did indeed pray hoping for a miracle.
//        -- Nothing happened of course!
//        -- But father Joseph was sitting behind me by the time I was done praying.
//        AStop
//        FJStart
//        c) Talk with father Joseph.
//        -- Father Joseph is considered a local historian of a sort. He told me about lot of interesting details about the island and also about the praying alter at this church and  . . .
//        --  . . . about the big goblet with a big green emerald. So I got . .
//        --  . . .the goblet! Well, I kind of stole it!!
//        FJStop
//        MStart
//        d) Talk with sister Mary.
//        -- Sister Mary was a very charming to talk to and she informed me that . . .
//        -- . . .Father Joseph is a good person to get the most information about anything related to this island.
//        MStop
//
//        2) Saint's Lodge
//        SLStart
//        a) Talk with manager
//        -- This manager has worked at this hotel for 30 years and could have some useful information
//        -- He told me to go talk to Joe. He hand out back by the patio.
//        -- This was a setup, John caught up to me with his gang!
//        --Lost health
//        SLStop
//        PAStart
//        b) Investigate the patio area.
//        -- It was a setup and got wacked by John and his goonies.
//        -- Lost health
//        PAStop
//        MRStart
//        c) Check my room
//        -- Something smells fishy, I better go to my room and make sure that I am safe first.
//        -- I went to my room . .
//        -- John took his revenge on me as he was waiting there to get his revenge!
//        -- Lost Health
//        MRStop
//
//        d)
//
//        3) Double Cross Tavern
//        TCStart
//        a)  Talk with Carlos
//        -- This guys has been a bartender here for long time and a old friend.
//        -- Talking to him yielded  . . .
//        --Nothing! he wanted me to stop this stupid adventure.
//        TCStop
//        BAStart
//        b)  Explore the basement.
//        --I know there is a hidden passage in the basement.
//        -- I found a door hidden under the carpet.
//        -- I had to pray it open as it was stuck.
//        -- there were stairs leading downstairs, I grabbed a candle and went down.
//        -- It lead to a room and I found . . .
//        --Nothing
//        BAStop
//        DStart
//        c)  Investigate the roof deck.
//        -- Lot of interesting characters hangout on the rooftop.
//        -- on this particular day there were only few people hanging out up top.
//        -- But I found . . .
//        -- A small bag of coins on the floor!
//        --Found coins!
//        DStop
//        d)
//
//        Southend Beach
//        SHStart
//        a) Visit Sail High ship company.
//        -- This is the place to get one of the best places to get a new ship
//        -- They have one ship here that I am really interested in buying soon . . .
//        -- Right now I don't have enough money. So nothing for me.
//        SHStop
//        FStart
//        b) Talk with Frank, he is famous pirate navigator.
//        -- I am really interested in having Frank as my navigator.
//        -- Informing him of all the information I have, he agreed to help me out for 10% cut.
//        -- I have a navigator!
//        FStop
//        GHStart
//        c) Visit my grandma's house.
//        -- I visited my grandma before I left for Treasure Island.
//        -- I told her about my plan.
//        -- She listened to what I have accomplished and planned.
//        -- She told me she is really proud of me and that I may accomplish what my dad and granddad couldn't.
//        -- But she told me that I just need to remember that sometimes the treasures are not what they seem to be.
//        GHStop
//        d)
//
//        Treasure Island
//        TIStart
//        -- What! I have been to this island before, there are people inhibiting this island!!
//        -- How can treasure be on this island? It is supposed to be the biggest treasure in the world.
//        -- This is confusing, I have to figure out a way to make some sense of this situation.
//        -- Or else all this situation will be for nothing.
//
//
//
//        -- After revisiting the clues, I think I figured it out.
//        -- I need to get to this hidden monastery and I will find more info there.
//
//        -- Talking with the monks there, I found out that they had a very sacred jewel stolen from them years back.
//        -- Now that sounds interesting, the description they provided matched with the jewel I posses.
//
//        -- Should I give this jewel back to the monastery?
//
//        -- I gave the jewel to monastery and in return they provided me with a medium size box which had . . .
//        -- Three keyholes in it!
//        -- I took the box with me to open it privately.
//        -- Upon opening it I found . . .
//        -- Jewels, coins and the most treasured 5o carat diamond!
