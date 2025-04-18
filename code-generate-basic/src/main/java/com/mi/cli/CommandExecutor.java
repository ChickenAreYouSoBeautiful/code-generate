package com.mi.cli;



import com.mi.cli.command.ConfigCommand;
import com.mi.cli.command.GenerateCommand;
import com.mi.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * 主命令
 * @author mi
 * @data 2025/4/17 11:30
 * @version 1.0
 */
@Command(name = "code", mixinStandardHelpOptions = true, version = "command 0.1")
public class CommandExecutor implements Runnable{

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new GenerateCommand());
    }

    @Override
    public void run() {
        System.out.println("输入 --help 查看帮助信息");
    }

    /**
     * 执行命令
     * @param args
     * @return
     */
    public Integer doExecutor(String[] args){
        return commandLine.execute(args);
    }
}
