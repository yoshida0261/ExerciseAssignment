package com.company.stah;
import org.apache.commons.cli.*;


public class CommandParser {

    private boolean isFind = false;
    private boolean isSet = false;

    public void Parser(String[] args) {

        Options opts = new Options();
        opts.addOption("f", "find", true, "Find Start-End Event mode.");
        opts.addOption("s", "set_schedule", true, "Set Schedule ");
        opts.addOption("d", "debug", false, "out put log mode");

        //ss -s date event
        //ss -f start end

        Option date   = Option.builder()
                .hasArg()
                .desc("Scheduled date")
                .argName("date")
                .build();
        Option event = Option.builder()
                .hasArg()
                .desc("Scheduled event")
                .argName("event")
                .build();
        Option start = Option.builder()
                .hasArg()
                .desc("start date")
                .argName("start date")
                .build();

        Option end = Option.builder()
                .hasArg()
                .desc("end date")
                .argName("")
                .build();
        opts.addOption(date);
        opts.addOption(event);
        opts.addOption(start);
        opts.addOption(end);



        DefaultParser parser = new DefaultParser();
        CommandLine cl;
        HelpFormatter help = new HelpFormatter();

        boolean debugFlag = false;

        try {
            cl = parser.parse(opts, args);
            if ( cl.hasOption("-f") ) isFind = true;
            if ( cl.hasOption("-d") ) debugFlag = true;

            System.out.println("Starting application...");
            System.out.println("Set Date mode : " + isSet);
            System.out.println("Find mode     : " + isFind);
            System.out.println("Debug mode    : " + debugFlag);

            // todo
            // validate

            // event <256
            // event 全角

            // date YYYYMMDDhhmm
            // date 正しい日付


        } catch (ParseException e) {
            help.printHelp("My Java Application", opts);
            System.exit(1);
        }
    }


    public void Set(Event event, DateYYYYMMDDhhmm date)
    {

    }
}
