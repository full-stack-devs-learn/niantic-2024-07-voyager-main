package com.nianatic;

public class Exercises
{
    /*
     * In this function you need to convert a word
     * either to all upper case letters or all
     * lower case.
     *
     * The user will provide you with the word, and
     * which case you should change it to.
     *
     * changeCase("Fancy", false) => fancy
     * changeCase("chocolate", true) => CHOCOLATE
     * changeCase("PARTY", false) => party
     * changeCase("PARTY", true) => PARTY
     *
     */
    public String changeCase(String word, boolean toUpperCase)
    {
        return null;
    }

    /*
     * As a full stack developer you will often need to
     * dynamically create Html in code. In this function
     * you are required to take the input and convert it
     * to a valid Html String.
     *
     * Html is made up of elements (also known as tags)
     * such as:
     *
     * <p>your content here</p>
     *
     * The element is <p> for paragraph
     *
     * Most elements have both an opening <p>
     * and a closing </p> tag, and the content
     * goes inside.
     *
     * The user will provide you with the content, and
     * the name of Html element.
     *
     * You need to return the formatted Html
     *
     * createHtml("This is a paragraph", "p") => <p>This is a paragraph</p>
     * createHtml("Bold text", "strong") => <strong>Bold text</strong>
     *
     */
    public String createHtml(String content, String elementName)
    {
        return null;
    }

    /*
     * Sometimes Html elements do not have any content
     *
     * <p></p>
     *
     * Elements that have no content can be "self closing".
     *
     * <p />
     *
     * Modify the logic that you used for the CreateHtml
     * to return a self closing element when there is no
     * content provided.
     *
     * moreHtml("This is a paragraph", "p") => <p>This is a paragraph</p>
     * moreHtml("", "p") => <p />
     *
     */
    public String moreHtml(String content, String elementName)
    {
        return null;
    }

    /*
     * Xml is similar to Html - it uses element names
     * to describe the data that is being stored.
     *
     * Unlike html, however, there are no pre-defined
     * element names in xml. In other words, you can use
     * any word as a tag name.
     *
     * <customer><id>1</id><name>Belinda Carter</name></customer>
     *
     * The user has a list of customer id and names. They
     * will provide you each customer id and their name.
     * You are required to return a formatted xml String
     * like the pattern shown above.
     *
     * createXml(1, "Belinda Carter") => <customer><id>1</id><name>Belinda Carter</name></customer>
     *
     */
    public String createXml(int id, String name)
    {
        return  null;
    }

    /*
     * The customer has noted that even though
     * the xml that is returned is correct, it is still
     * somewhat difficult to read because it is all on
     * a single line
     *
     * <customer><id>1</id><name>Belinda Carter</name></customer>
     *
     * Xml can be made easier to read by adding line breaks
     * and indentation like this:
     * (note: indentations are 2 spaces)
     *
     * <customer>
     *   <id>1</id>
     *   <name>Belinda Carter</name>
     * </customer>
     *
     * Modify your logic to return formatted xml.
     * each element must be on its own line.
     * Indent the nested elements with 2 spaces
     *
     * String format codes (see https://www.w3schools.com/java/java_Strings_specchars.asp):
     * \n = new line
     * \t = tab
     * \\ = \
     *
     * formattedXml(1, "Belinda Carter") => <customer>
     *                                        <id>1</id>
     *                                        <name>Belinda Carter</name>
     *                                      </customer>
     *
     */
    public String formattedXml(int id, String name)
    {
        return null;
    }

    /*
     * In this function you will be given all the
     * individual parts of a full name. You need to
     * return the fully formatted name as a single String
     *
     * The first and last names will always have a value,
     * but a user is not required to have a middle name
     * or a suffix.
     *
     * If middle name or suffix is provided, you must
     * format the name accordingly.
     *
     * Examples:
     * formatFullName("Glen", "", "Williamson", "") => Glen Williamson
     * formatFullName("Glen", "Carter", "Williamson", "") => Glen Carter Williamson
     * formatFullName("Glen", "", "Williamson", "Jr") => Glen Williamson, Jr
     * formatFullName("Glen", "Carter", "Williamson", "Jr") => Glen Carter Williamson, Jr
     *
     */
    public String formatFullName(String firstName, String middleName, String lastName, String suffix)
    {
        return  null;
    }

    /*
     * You are writing a program for HR.
     * When they hire a new employee they must be
     * given an username to access the network.
     *
     * The username must always be lower case and
     * is formatted as the employees first name
     * and last name separated by a period.
     *
     * Glen Williamson => glen.willimason
     *
     * If the employee has a middle name, the
     * middle initial should also be added like
     * this
     *
     * Glen Carter Williamson => glen.c.williamson
     *
     * Your function accepts the full name of the employee
     * and you must return the new username.
     *
     * Examples:
     * createUserName("Glen Williamson") => glen.williamson
     * createUserName("Glen Carter Williamson") => glen.c.williamson
     * createUserName("Glen Williamson, III") => glen.williamson
     *
     */
    public String createUserName(String fullName)
    {
        // 1. it must be lowercase
        String lowerCaseFullName = fullName.strip().toLowerCase();

        // 2. remove suffix (anything after the comma)
        String[] fullNameParts = lowerCaseFullName.split(",");
        String nameOnly = fullNameParts[0];

        // 3. middle names should only use the first letter
        String[] names = nameOnly.split(" ");
        String firstName = names[0];
        String middleName = "";
        String lastName = "";

        if(names.length > 2)
        {
            // there is a middle name
            middleName = names[1].substring(0,1);
            lastName = names[2];
        }
        else
        {
            // there is NO middle name
            lastName = names[1];
        }

        // 4. separate name parts with .
        String userName = middleName.isEmpty()
                            ? firstName + "." + lastName
                            : firstName + "." + middleName + "." + lastName;

//        if(middleName.isEmpty())
//        {
//            userName = firstName + "." + lastName;
//        }
//        else
//        {
//            userName = firstName + "." + middleName + "." + lastName;
//        }

//        switch(middleName)
//        {
//            case "":
//                userName = firstName + "." + lastName;
//                break;
//            default:
//                userName = firstName + "." + middleName + "." + lastName;
//                break;
//        }

        return userName;
    }
}
