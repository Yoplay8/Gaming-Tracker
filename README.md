# Abstract View
This was a personal project I started to help keep track of how much time I spent on playing games, watching youtube, or anything that didn't get me closer to my personal goals in life.

The program will keep track of all the time spent doing such activities and the user is responsible for spending more time doing productive activities over unproductive activities. The user will be able to add into the program what is deemed as productive and how much time will be added based on the given activity. All productive activities will be saved in the program with the amount to add. Interest is applied on a daily bases. This is to work as an insensitive for the user. If the user has spent more time being unproductive then the interest will put them farther in debt as an insensitive to make them work harder. Where as if the user has spent more time being productive then they will be rewarded by the interest giving them more productivity time.

The main idea behind this was kind of like a banking system. Productive time is equal to receiving cash and unproductive time is equal to spending cash. Interest is applied in the positive or negative direction depending on the total amount of cash the user has. Maybe using the word interest isn't the best word. Future improvements may change this word to better depict what's actually happening. 


# Full View (Incomplete)
The user will be able to enter in the amount of time spent doing an unproductive activity. Note, time will have to be converted to decimals. Every time the user enters in spent time a file will be updated to hold the correct total amount of time. On the same interface the user will be able to see how much time they have. All time entered on the input time interface will automatically deduct the time from the total time. Input is also checked before updating the file incase the user enters in letters. The program doesn't check to see if the user entered in a negative amount of time resulting in adding instead of subtracting. Example, (Total time - (-Input Time))

The list of accountabilities section will hold a list of productive activities that the user can select. This interface will be dynamic so the user can manually enter in productive activities. They will also have to option to delete already entered activities. Activities will be entered by providing the name and amount of time to add to the total. Once the activity is saved all the user will have to do is indicate how many times they did that activity. Example, the user has the activity run 1 mile which will count as 1 hour of productive time. If the user ran 5 miles they can enter in that they did 1 mile 5 times and they will gain 5 hours of productivity. <b>This page is still in progress</b>

The display averages section will display how each day ended for the past 30 days. Example, the user spent 5 hours being unproductive and 10 hours being productive the display average for that day will show a +5 indicating on that day they were more productive. This is to help show the user that they are more productive on certain days than others. This could help them to adjust on certain days or help them understand why they are more or less productive on certain days.

The apply interest section is a way for the user to apply their daily interest. Example, the user hasn't opened up the program in a few days. A file saves the last time interest was applied to help track this. If the user hasn't logged in for 3 days the interest button will show up displaying 'interest(3)' Indicating the number of days behind they are. This will allow the user to be truthful. If they can recall exactly what they did for the past 3 days. They can still enter in all productivity time and apply the interest for each day. The reason the program doesn't automatically apply interest is because of my personal experiences. Where one of my productive activities involved something during night time. I didn't want to open up the program at 11pm. So this is an option for the user to add or subtract time the next day and catch up. If the user is all caught up on applying interst the button will not display.


# Future Ideas
Input section will have a drop down menu for hours and minutes. Instead of making the user convert hours to decimals.

Display averages section will display every day of the week so the user doesn't have to figure out what day is what.

Apply interest section will maybe have to change. I don't know why at the moment but, I get the feeling that this needs an improvement some where on how this works.

For the overall program if the user has a negative amount of time then programs will be blocked. Maybe we could even do websites. The first implementation will involve the user deciding what programs should be blocked. The second implementation will involve the program deciding what programs to block by tracking the amount of time a certain program was spent running and to block the programs that were running the longest maybe indicting that those programs where the ones causing the user to be unproductive. This could help eliminate the user from cheating. Of course this may not be the best solution because theirs no guarantee that the 2nd implementation will block the correct programs and I don't want to keep track inside of a file on how long each program was running. Even if the 2nd implementation isn't practical I still think we need a 2nd implementation because I don't want the user to have too much control. Because I know first hand how deceptive I can be and unreasonable when it comes to telling the truth when a program wants to block my favorite unproductive activities.

The interface will for sure need to be redone. This was my first big project in Java so I was kind of experimenting and adding in random backgrounds and styles.

# My Notes

