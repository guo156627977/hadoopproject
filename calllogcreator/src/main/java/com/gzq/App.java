package com.gzq;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Hello world!
 */
public class App {

    static Random random = new Random();

    public static Map<String, String> callers = new HashMap<String, String>();
    public static List<String> phoneNumbers = new ArrayList<String>();

    static {
        callers.put("1391317838040 ", " 章亨 ");
        callers.put("1373263172540 ", " 阚枝萍 ");
        callers.put("1373263671040 ", " 戎河福 ");
        callers.put("1373263698540 ", " 王岚 ");
        callers.put("1585018438140 ", " 冶斌 ");
        callers.put("1381484639845 ", " 司黛淑 ");
        callers.put("1373263818840 ", " 马淑馥 ");
        callers.put("1373263928535 ", " 于士 ");
        callers.put("1373263926745 ", " 仇德 ");
        callers.put("1373263403340 ", " 李三 ");
        callers.put("1373263857740 ", " 荣路 ");
        callers.put("1373263705232 ", " 顾浩 ");
        callers.put("1373263265840 ", " 刘姗姗 ");
        callers.put("1373263795635 ", " 韩宇 ");
        phoneNumbers.addAll(callers.keySet());

    }


    public static void main(String[] args) throws IOException {

        //String a = "1";
        if (args == null || args.length == 0 ) {
            System.out.println("no args");
            System.exit(-1);
        }

        while (true) {
            gencalllog(args[0]);
            //gencalllog(a);
        }

    }

    private static void gencalllog(String string) throws IOException {
        //FileWriter fileWriter = new FileWriter("D:\\calllog.txt", true);
        FileWriter fileWriter = new FileWriter(string, true);
        //取主叫
        String caller = phoneNumbers.get(random.nextInt(phoneNumbers.size()));
        String callerName = callers.get(caller);
        //被叫
        String callee = null;
        while (true) {
            callee = phoneNumbers.get(random.nextInt(phoneNumbers.size()));
            if (!callee.equals(caller)) {
                break;
            }
        }
        String calleeName = callers.get(callee);

        int duration = random.nextInt(60 * 10) + 1;
        String dateStr = randomDateBetweenMinAndMax();

        String log = caller + "," + callee + "," + dateStr + "," + duration + "\n";

        fileWriter.write(log);
        fileWriter.flush();
        //System.out.print("log = " + log);
    }

    public static String randomDateBetweenMinAndMax() {
        Calendar calendar = Calendar.getInstance();
        //注意月份要减去1
        calendar.set(2017, 0, 1);
        calendar.getTime().getTime();
        //根据需求，这里要将时分秒设置为0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long min = calendar.getTime().getTime();
        //System.out.println("min = " + min);
        calendar.set(2018, 0, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        long max = calendar.getTime().getTime();
        //System.out.println("max = " + max);
        //得到大于等于min小于max的double值
        double randomDate = Math.random() * (max - min) + min;
        //将double值舍入为整数，转化成long类型
        calendar.setTimeInMillis(Math.round(randomDate));
        Date date = calendar.getTime();
        Date now = new Date();
        //todo 这里如果时间大于当前时间需要在改一下
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        return format;
    }


}
