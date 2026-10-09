package com.kingdomlife.app;

import java.util.ArrayList;

public class BibleJourneyRevelationData {

    public static void addRevelationQuestions(
            ArrayList<BibleJourneyData.Question> questions,
            String difficulty
    ) {
    
    if (difficulty.equals("Easy")) {

        questions.add(new BibleJourneyData.Question(
                "Who received the Revelation?",
                new String[]{
                        "Peter",
                        "John",
                        "Paul",
                        "James"
                },
                1
        ));

        questions.add(new BibleJourneyData.Question(
                "Where was John when he received the Revelation?",
                new String[]{
                        "Patmos",
                        "Jerusalem",
                        "Rome",
                        "Ephesus"
                },
                0
        ));

        questions.add(new BibleJourneyData.Question(
                "What is the first church addressed in Revelation?",
                new String[]{
                        "Smyrna",
                        "Pergamos",
                        "Ephesus",
                        "Laodicea"
                },
                2
        ));

        questions.add(new BibleJourneyData.Question(
                "How many churches are addressed in Revelation chapters 2 and 3?",
                new String[]{
                        "Seven",
                        "Five",
                        "Ten",
                        "Twelve"
                },
                0
        ));

        questions.add(new BibleJourneyData.Question(
                "What does Jesus call Himself in the message to the church at Smyrna?",
                new String[]{
                        "The beginning and the end",
                        "The first and the last",
                        "The great prophet",
                        "The King of Rome"
                },
                1
        ));

        questions.add(new BibleJourneyData.Question(
                "What did John see in heaven after the messages to the churches?",
                new String[]{
                        "A throne",
                        "A temple",
                        "A city",
                        "A mountain"
                },
                0
        ));

        questions.add(new BibleJourneyData.Question(
                "How many elders were around the throne?",
                new String[]{
                        "Twelve",
                        "Twenty-four",
                        "Forty",
                        "Seventy"
                },
                1
        ));

        questions.add(new BibleJourneyData.Question(
                "How many living creatures were around the throne?",
                new String[]{
                        "Two",
                        "Seven",
                        "Four",
                        "Twelve"
                },
                2
        ));

        questions.add(new BibleJourneyData.Question(
                "Who was worthy to open the book?",
                new String[]{
                        "The Lion of the tribe of Judah",
                        "Michael",
                        "Peter",
                        "John"
                },
                0
        ));

        questions.add(new BibleJourneyData.Question(
                "What did John see standing in the midst of the throne?",
                new String[]{
                        "A king",
                        "A lamb as it had been slain",
                        "An angel",
                        "A prophet"
                },
                1
        ));

        questions.add(new BibleJourneyData.Question(
                "How many seals were on the book?",
                new String[]{
                        "Four",
                        "Seven",
                        "Ten",
                        "Twelve"
                },
                1
        ));

        questions.add(new BibleJourneyData.Question(
                "What appeared when the first seal was opened?",
                new String[]{
                        "A white horse",
                        "A red dragon",
                        "A great eagle",
                        "A golden city"
                },
                0
        ));

        questions.add(new BibleJourneyData.Question(
                "What appeared when the second seal was opened?",
                new String[]{
                        "A black horse",
                        "A white horse",
                        "A red horse",
                        "A pale horse"
                },
                2
        ));

        questions.add(new BibleJourneyData.Question(
                "What appeared when the fourth seal was opened?",
                new String[]{
                        "A white horse",
                        "A pale horse",
                        "A red horse",
                        "A black horse"
                },
                1
        ));

        questions.add(new BibleJourneyData.Question(
                "How many people were sealed from the tribes of Israel?",
                new String[]{
                        "12,000",
                        "70,000",
                        "144,000",
                        "7,000"
                },
                2
        ));

        questions.add(new BibleJourneyData.Question(
                "How many angels stood before God with seven trumpets?",
                new String[]{
                        "Seven",
                        "Four",
                        "Twelve",
                        "Twenty-four"
                },
                0
        ));

        questions.add(new BibleJourneyData.Question(
                "What came out of the bottomless pit in Revelation 9?",
                new String[]{
                        "A great army of locust-like creatures",
                        "A flood of water",
                        "A golden city",
                        "Seven kings"
                },
                0
        ));

        questions.add(new BibleJourneyData.Question(
                "What did John see coming down from heaven in Revelation 21?",
                new String[]{
                        "A new Jerusalem",
                        "A new Egypt",
                        "A new Rome",
                        "A new Babylon"
                },
                0
        ));

        questions.add(new BibleJourneyData.Question(
                "What did the New Jerusalem have instead of a temple?",
                new String[]{
                        "A great palace",
                        "The Lord God Almighty and the Lamb",
                        "A throne of David",
                        "Seven churches"
                },
                1
        ));

        questions.add(new BibleJourneyData.Question(
                "What will be no more in the new heaven and new earth?",
                new String[]{
                        "The sea",
                        "The sun",
                        "The moon",
                        "The stars"
                },
                0
        ));

        questions.add(new BibleJourneyData.Question(
                "What will God wipe away from their eyes?",
                new String[]{
                        "Sweat",
                        "Tears",
                        "Dust",
                        "Blood"
                },
                1
        ));

        questions.add(new BibleJourneyData.Question(
                "What will be no more?",
                new String[]{
                        "Death",
                        "Prayer",
                        "Worship",
                        "Faith"
                },
                0
        ));

        questions.add(new BibleJourneyData.Question(
                "What is the river in the New Jerusalem called?",
                new String[]{
                        "The river of life",
                        "The river of Jordan",
                        "The river of fire",
                        "The river of mercy"
                },
                0
        ));

        questions.add(new BibleJourneyData.Question(
                "What tree is mentioned in the New Jerusalem?",
                new String[]{
                        "The tree of knowledge",
                        "The tree of life",
                        "The olive tree",
                        "The fig tree"
                },
                1
        ));

        questions.add(new BibleJourneyData.Question(
                "What does Revelation say about the words of its prophecy?",
                new String[]{
                        "They are uncertain",
                        "They are only for kings",
                        "They are faithful and true",
                        "They are hidden forever"
                },
                2
        ));
    }
            if (difficulty.equals("Medium")) {

    questions.add(new BibleJourneyData.Question(
            "Who received the Revelation?",
            new String[]{
                    "John",
                    "Peter",
                    "Paul",
                    "James"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "Where was John when he received the Revelation?",
            new String[]{
                    "Jerusalem",
                    "The isle called Patmos",
                    "Rome",
                    "Ephesus"
            },
            1
    ));

    questions.add(new BibleJourneyData.Question(
            "What did John hear behind him on the Lord's day?",
            new String[]{
                    "A great voice",
                    "A trumpet only",
                    "Thunder",
                    "A choir"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "How many churches were specifically addressed in the opening chapters?",
            new String[]{
                    "Five",
                    "Six",
                    "Seven",
                    "Twelve"
            },
            2
    ));

    questions.add(new BibleJourneyData.Question(
            "Which church was described as having left its first love?",
            new String[]{
                    "Ephesus",
                    "Smyrna",
                    "Pergamos",
                    "Laodicea"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "Which church was told it would suffer tribulation?",
            new String[]{
                    "Ephesus",
                    "Smyrna",
                    "Sardis",
                    "Philadelphia"
            },
            1
    ));

    questions.add(new BibleJourneyData.Question(
            "Which church tolerated the teaching of Balaam?",
            new String[]{
                    "Pergamos",
                    "Smyrna",
                    "Ephesus",
                    "Philadelphia"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "Which church was warned about the woman Jezebel?",
            new String[]{
                    "Sardis",
                    "Thyatira",
                    "Smyrna",
                    "Laodicea"
            },
            1
    ));

    questions.add(new BibleJourneyData.Question(
            "Which church had a reputation that it was alive but was dead?",
            new String[]{
                    "Sardis",
                    "Philadelphia",
                    "Ephesus",
                    "Pergamos"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "Which church had an open door that no one could shut?",
            new String[]{
                    "Laodicea",
                    "Philadelphia",
                    "Sardis",
                    "Thyatira"
            },
            1
    ));

    questions.add(new BibleJourneyData.Question(
            "Which church was described as lukewarm?",
            new String[]{
                    "Ephesus",
                    "Pergamos",
                    "Laodicea",
                    "Smyrna"
            },
            2
    ));

    questions.add(new BibleJourneyData.Question(
            "What did John see around the throne in heaven?",
            new String[]{
                    "Four living creatures",
                    "Seven kings",
                    "Twelve priests",
                    "Three angels"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "What was in the right hand of Him who sat on the throne?",
            new String[]{
                    "A crown",
                    "A book sealed with seven seals",
                    "A sword",
                    "A trumpet"
            },
            1
    ));

    questions.add(new BibleJourneyData.Question(
            "Who was worthy to open the book?",
            new String[]{
                    "An angel",
                    "A prophet",
                    "The Lion of the tribe of Judah",
                    "Peter"
            },
            2
    ));

    questions.add(new BibleJourneyData.Question(
            "How is Jesus also described when He appears as worthy to open the book?",
            new String[]{
                    "The Lamb",
                    "The Prophet",
                    "The King of Rome",
                    "The High Priest of Jerusalem"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "What happened when the Lamb opened the first seal?",
            new String[]{
                    "A white horse appeared",
                    "The temple fell",
                    "The sea became blood",
                    "An earthquake occurred"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "What did the martyrs under the altar ask?",
            new String[]{
                    "Where is the temple?",
                    "How long before judgment and vengeance?",
                    "When will Rome fall?",
                    "Who will lead Israel?"
            },
            1
    ));

    questions.add(new BibleJourneyData.Question(
            "What did the seventh seal introduce?",
            new String[]{
                    "Silence in heaven",
                    "A new temple",
                    "A great feast",
                    "The final judgment immediately"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "What happened when the first trumpet was sounded?",
            new String[]{
                    "Hail and fire mixed with blood affected the earth",
                    "The sea became completely dry",
                    "The sun disappeared",
                    "The temple was rebuilt"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "What was one effect of the second trumpet?",
            new String[]{
                    "A mountain burning with fire was cast into the sea",
                    "The moon became dark",
                    "The stars fell to earth",
                    "Jerusalem was rebuilt"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "What did John see coming down from heaven near the end of the book?",
            new String[]{
                    "A new Jerusalem",
                    "A new Egypt",
                    "A new Rome",
                    "A new Babylon"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "What was special about the New Jerusalem?",
            new String[]{
                    "It had no temple",
                    "It had a Roman palace",
                    "It had a military fortress",
                    "It had a throne of David only"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "Why did the New Jerusalem have no need of the sun or moon?",
            new String[]{
                    "The city had no sky",
                    "The glory of God and the Lamb gave it light",
                    "The angels supplied electricity",
                    "The stars were brighter"
            },
            1
    ));

    questions.add(new BibleJourneyData.Question(
            "What was flowing from the throne of God and the Lamb?",
            new String[]{
                    "A river of the water of life",
                    "A river of fire",
                    "A river of blood",
                    "A river of oil"
            },
            0
    ));

    questions.add(new BibleJourneyData.Question(
            "What tree appears beside the river of life?",
            new String[]{
                    "The tree of knowledge",
                    "The tree of life",
                    "The olive tree",
                    "The fig tree"
            },
            1
    ));
                }
            if (difficulty.equals("Hard")) {
    questions.add(new BibleJourneyData.Question(
            "To whom was the Revelation given to show things which must shortly come to pass?",
            new String[]{"Paul", "John", "Peter", "James"},
            1));

    questions.add(new BibleJourneyData.Question(
            "What did John see in the midst of the seven golden candlesticks?",
            new String[]{"A lion", "A throne", "One like unto the Son of man", "A great eagle"},
            2));

    questions.add(new BibleJourneyData.Question(
            "What did the Son of man have in his right hand?",
            new String[]{"Seven stars", "A golden censer", "A book", "A sword"},
            0));

    questions.add(new BibleJourneyData.Question(
            "What came out of his mouth?",
            new String[]{"Fire", "A sharp twoedged sword", "Smoke", "Living water"},
            1));

    questions.add(new BibleJourneyData.Question(
            "What were the seven stars?",
            new String[]{"Seven angels", "Seven churches", "The angels of the seven churches", "Seven prophets"},
            2));

    questions.add(new BibleJourneyData.Question(
            "What did the church at Ephesus have against it?",
            new String[]{"It denied Christ", "It had no faith", "It refused baptism", "It had left its first love"},
            3));

    questions.add(new BibleJourneyData.Question(
            "What did the church at Smyrna have tribulation for?",
            new String[]{"Ten days", "Ten years", "Forty days", "Seven years"},
            0));

    questions.add(new BibleJourneyData.Question(
            "What did the church at Pergamos have among them?",
            new String[]{"The throne of Satan", "The temple of Solomon", "The ark of the covenant", "The seat of Moses"},
            0));

    questions.add(new BibleJourneyData.Question(
            "What was the name of the faithful martyr at Pergamos?",
            new String[]{"Antipas", "Nicolas", "Diotrephes", "Demetrius"},
            0));

    questions.add(new BibleJourneyData.Question(
            "What did the church at Thyatira suffer by allowing?",
            new String[]{"A false prophetess called Jezebel", "A Roman governor", "A false apostle named Demas", "A false king"},
            0));

    questions.add(new BibleJourneyData.Question(
            "What did the church at Sardis have that was about to die?",
            new String[]{"Its temple", "The things which remained", "Its leaders", "Its wealth"},
            1));

    questions.add(new BibleJourneyData.Question(
            "What did the church at Philadelphia have that no man could shut?",
            new String[]{"A golden gate", "A heavenly temple", "An open door", "A sealed book"},
            2));

    questions.add(new BibleJourneyData.Question(
            "What did the church at Laodicea say it was rich in?",
            new String[]{"Gold and silver", "Wisdom", "Good works", "Goods"},
            3));

    questions.add(new BibleJourneyData.Question(
            "What did John see around the throne in Revelation 4?",
            new String[]{"Twenty-four elders", "Seventy elders", "Twelve priests", "Four kings"},
            0));

    questions.add(new BibleJourneyData.Question(
            "How many living creatures were around the throne?",
            new String[]{"Two", "Four", "Seven", "Twelve"},
            1));

    questions.add(new BibleJourneyData.Question(
            "What did the four living creatures continually say?",
            new String[]{"Worthy is the Lamb", "Holy, holy, holy, Lord God Almighty", "Alleluia forever", "Glory to the King"},
            1));

    questions.add(new BibleJourneyData.Question(
            "How many seals were on the book in the right hand of him that sat upon the throne?",
            new String[]{"Four", "Five", "Seven", "Twelve"},
            2));

    questions.add(new BibleJourneyData.Question(
            "Who was found worthy to open the book and loose its seals?",
            new String[]{"A mighty angel", "One of the elders", "John", "The Lion of the tribe of Judah, the Root of David"},
            3));

    questions.add(new BibleJourneyData.Question(
            "What appeared when the third seal was opened?",
            new String[]{"A black horse", "A white horse", "A red horse", "A pale horse"},
            0));

    questions.add(new BibleJourneyData.Question(
            "What did the rider of the black horse have in his hand?",
            new String[]{"A sword", "A pair of balances", "A bow", "A crown"},
            1));

    questions.add(new BibleJourneyData.Question(
            "What followed the opening of the fourth seal?",
            new String[]{"A white horse", "A red horse", "A pale horse", "A black horse"},
            2));

    questions.add(new BibleJourneyData.Question(
            "What name was given to the rider of the pale horse?",
            new String[]{"Death", "Abaddon", "Armageddon", "Famine"},
            0));

    questions.add(new BibleJourneyData.Question(
            "How many servants of God were sealed in Revelation 7?",
            new String[]{"12,000", "144,000", "70,000", "1,000,000"},
            1));

    questions.add(new BibleJourneyData.Question(
            "How many were sealed from each tribe of the children of Israel?",
            new String[]{"1,000", "10,000", "12,000", "24,000"},
            2));

    questions.add(new BibleJourneyData.Question(
            "What did John see coming down from God out of heaven at the end of Revelation?",
            new String[]{"A new temple", "A new mountain", "A new throne", "The holy city, new Jerusalem"},
            3));
                }
    }
}
