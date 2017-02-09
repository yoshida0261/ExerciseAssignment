package com.company.stah;
import org.apache.commons.cli.*;


public class CommandParser {

    private boolean isFind = false;
    private boolean isSet = false;
    private int max = 0;
    private String filePath = null;

    public boolean isFind() {
        return isFind;
    }

    public boolean isSet() {
        return isSet;
    }

    public int getMax() {
        return max;
    }

    public Event getEvent() {
        return event;
    }

    public DateYYYYMMDDhhmm getDate() {
        return date;
    }

    public DateYYYYMMDDhhmm getStart() {
        return start;
    }

    public DateYYYYMMDDhhmm getEnd() {
        return end;
    }

    private Event event = null;
    private DateYYYYMMDDhhmm date = null;
    private DateYYYYMMDDhhmm start = null;
    private DateYYYYMMDDhhmm end = null;

    public void parser(String[] args) {

        Options opts = new Options();
        opts.addOption("f", "find", false, "Find Start-End Event mode.");
        opts.addOption("s", "set_schedule", false, "Set Schedule ");
        opts.addOption("d", "debug", false, "out put log mode");

        Option maxOpt = Option.builder("max")
                .required(false)
                .hasArg(true)
                .desc("Event max count")
                .argName("max")
                .build();

        Option dateOpt   = Option.builder("date")
                .required(false)
                .hasArg(true)
                .desc("Scheduled date")
                .argName("date")
                .build();
        Option eventOpt = Option.builder("event")
                .required(false)
                .hasArg(true)
                .desc("Scheduled event")
                .argName("event")
                .build();
        Option startOpt = Option.builder("start")
                .required(false)
                .hasArg(true)
                .desc("start date")
                .argName("start date")
                .build();

        Option endOpt = Option.builder("end")
                .required(false)
                .hasArg(true)
                .desc("end date")
                .argName("end date")
                .build();
        Option fileOpt = Option.builder("filepath")
                .required(false)
                .hasArg(true)
                .desc("output file path")
                .argName("file path")
                .build();

        opts.addOption(maxOpt);
        opts.addOption(dateOpt);
        opts.addOption(eventOpt);
        opts.addOption(startOpt);
        opts.addOption(endOpt);
        opts.addOption(fileOpt);

        DefaultParser parser = new DefaultParser();
        CommandLine cl;

        boolean debugFlag = false;

        try {
            cl = parser.parse(opts, args);

            if( cl.hasOption("s") && cl.hasOption("f") ) return;

            if ( cl.hasOption("s") ) {
                isSet = true;
                if ( cl.hasOption("event")) event = new Event(cl.getOptionValue("event"));
                if ( cl.hasOption("date")) date = new DateYYYYMMDDhhmm(cl.getOptionValue("date"));

            }
            if ( cl.hasOption("f") ) {
                isFind = true;
                if ( cl.hasOption("start")) start = new DateYYYYMMDDhhmm(cl.getOptionValue("start"));
                if ( cl.hasOption("end")) end = new DateYYYYMMDDhhmm(cl.getOptionValue("end"));
            }
            if ( cl.hasOption("d") ) debugFlag = true;
            if ( cl.hasOption("max")) max = Integer.parseInt(cl.getOptionValue("max"));
            if ( cl.hasOption("filepath")) filePath = cl.getOptionValue("filepath");


        } catch (ParseException e) {
            HelpFormatter help = new HelpFormatter();
            help.printHelp("My Java Application", opts);
            System.exit(1);
        }

        System.out.println("Starting application...");
        System.out.println("SetEvent mode : " + isSet);
        System.out.println("Find     mode : " + isFind);
        System.out.println("Debug    mode : " + debugFlag);
        System.out.println("max     count : " + max);
        if(event != null) System.out.println("event         : " + event.getEvent());
        if(date != null)  System.out.println("date          : " + date.getDate());
        if(start != null) System.out.println("start         : " + start.getDate());
        if(end != null)   System.out.println("end           : " + end.getDate());
        System.out.println("file path     : " + filePath);

    }





}
