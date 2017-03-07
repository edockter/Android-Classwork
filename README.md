# IUPUI CIT30500 - Android Classwork
### In-class changes 3/6:
##### Set up GreenDAO Object Relational Management (ORM) system and a SQLite database.  
##### [Guide for Today's changes](https://docs.google.com/document/d/1OcDwosMioMxkrSkbsAKkRAjqxLRwnP6rhI3vxZ_gYPA/edit?usp=sharing)

<hr/>

### In-class changes 3/1:
##### Today we made the menu work.  Different fragments are loaded when navigation is changed.  We changed the item names on the menus. Talked about icons.
* We changed SingleFragmentActivity's onNavigationItemSelected() method.  Uses the FragmentManager to change fragments when a menu item is selected.
* We added an icon resource.  Icon resources can be added by:
  1. Right-click "res" folder.
  1. Select New -> Vector Asset.
  1. Change name if desired (probably best not to).
  1. Click Icon button to change icon.
* We need to change the icons on our menu to things that make sense.  Your choice!  Add them and use the drawable references in the XML file to point to the new Drawable.
* We talked about using the Iconify library to display icons from icon fonts (like FontAwesome, IonIcons, etc) in an easy way.  Will probably end up doing this.
