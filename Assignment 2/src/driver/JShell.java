package driver;

// **********************************************************
// Assignment2:
// UTOR user_name1: guptaak2
// UTOR user_name2: ahmadab2
// UTOR user_name3: abbass13
// UTOR user_name4: mangats2
//
// Author1: Akhil Gupta
// Author2: Abdul Ahad Ahmad
// Author3: Syed M Farjad Abbas
// Author4: Satbir Mangat
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC 207 and understand the consequences.
// *********************************************************

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JShell {

	public static void main(String[] args) throws IOException {
		Directory dir = new Directory("/");
		Redirection redirect = new Redirection();
		fileStack fs = new fileStack();
		File curDir = dir;

		// mkdir mk = new mkdir();
		// //pwd pwd = new pwd(dir.getSubDirs().get(1));
		// mk.addDirectoryRelative("hello", dir);
		// mk.addDirectoryRelative("sup", dir.getSubDirs().get(1));
		// mk.addDirectoryRelative("sup", dir.getSubDirs().get(1));
		// pwd pwd1 = new pwd(dir.getSubDirs().get(1));
		// ls hello = new ls(dir.getSubDirs().get(1));

		boolean run_prompt = true;
		// while loop to continue running command prompt
		while (run_prompt) {
			String user_input;
			int StartQuote = -1;
			int EndQuote = -1;

			String invalidChar = "!@$&*()?:[]`|={},;";
			boolean commandValidity = true;

			cd cd = new cd();
			// cd.setCurDir(dir);
			// System.out.println(dir.getSubDirs());

			Scanner in = new Scanner(System.in);
			// asks user to enter command after "/#: "
			System.out.print("/#: ");
			user_input = in.nextLine();

			// splits user_input in a list
			String[] input = user_input.split(" +");

			for (int i = 0; i < user_input.length(); i++) {
				if (user_input.charAt(i) == '"' && StartQuote < 0) {
					StartQuote = i;
				} else if (user_input.charAt(i) == '"' && StartQuote >= 0) {
					EndQuote = i;
				}
			}
			String content = null;
			// System.out.println(user_input.subSequence(StartQuote+1,
			// EndQuote));
			if (EndQuote > StartQuote) {
				content = (String) user_input.subSequence(StartQuote + 1,
						EndQuote);
			}
			if (input.length >= 1) {
				input[0] = input[0].toLowerCase();
			}

			if (user_input.equals("exit")) {
				// Case 1: "exit", it quits the program
				System.exit(0);

			} else if (!commandValidity) {
				System.out.println("Invalid command, please try again.");
			} else if (input[0].equals("man") && input.length == 2) {

				man manual = new man(input[1]);
				System.out.println(manual.documentation);

			} else if (input[0].equals("mkdir") && input.length > 1) {

				// Case 2: "mkdir"
				mkdir addDir = new mkdir();
				addDir.addAll(input, dir, curDir);

				// System.out.println(dir.subDirs);

			} else if (input[0].equals("echo") && input.length == 2
					&& content != null) {
				System.out.println(content);

			} else if (input[0].equals("ls") && input.length == 3
					&& (input[1].equals(">") || input[1].equals(">>"))) {
				redirect.RedirectionLSRelative(dir, curDir, input[2], input[1],
						false);
			} else if (input[0].equals("ls") && input.length == 4
					&& input[1].toLowerCase().equals("-r")
					&& (input[2].equals(">") || input[2].equals(">>"))) {
				redirect.RedirectionLSRelative(dir, curDir, input[3], input[2],
						true);
			} else if (input[0].equals("ls")
					&& input.length >= 4
					&& !input[1].toLowerCase().equals("-r")
					&& (input[input.length - 2].equals(">") || input[input.length - 2]
							.equals(">>"))) {
				for (int i = 1; i < input.length - 2; i++) {
					if (input[input.length - 2].equals(">") && i > 1) {
						redirect.RedirectionLSPath(input[i], dir, curDir,
								input[input.length - 1], ">>", false);
					} else {
						redirect.RedirectionLSPath(input[i], dir, curDir,
								input[input.length - 1],
								input[input.length - 2], false);
					}
				}

			} else if (input[0].equals("ls")
					&& input.length >= 5
					&& input[1].toLowerCase().equals("-r")
					&& (input[input.length - 2].equals(">") || input[input.length - 2]
							.equals(">>"))) {
				for (int i = 2; i < input.length - 2; i++) {
					if (input[input.length - 2].equals(">") && i > 2) {
						redirect.RedirectionLSPath(input[i], dir, curDir,
								input[input.length - 1], ">>", true);
					} else {
						redirect.RedirectionLSPath(input[i], dir, curDir,
								input[input.length - 1],
								input[input.length - 2], true);
					}
				}
			}

			else if (input[0].equals("cd") && input.length == 2) {
				cd ChangeDir = new cd();
				curDir = ChangeDir.ChangeDirectory(input[1], dir, curDir);
				// System.out.println(ChangeDir.currentDir);

			} else if (input[0].equals("pwd") && input.length == 3
					&& (input[1].equals(">") || input[1].equals(">>"))) {

				redirect.RedirectionPWD(input[2], dir, curDir, input[1]);
			} else if (input[0].equals("cat") && input.length == 4
					&& (input[2].equals(">") || input[2].equals(">>"))) {

				redirect.RedirectionCAT(input[1], input[3], dir, curDir,
						input[2]);
			} else if (input[0].equals("man") && input.length == 4
					&& (input[2].equals(">") || input[2].equals(">>"))) {

				redirect.RedirectionCMD(input[1], input[3], dir, curDir,
						input[2]);
			}

			else if (input[0].equals("ls")) {
				// PathHandler handle = new PathHandler();
				// Case 4: "ls"
				// System.out.println(input[0]);
				// ls ListDir = new ls(cd.getCurDir());
				PathHandler handle = new PathHandler();
				if (input.length == 1) {
					ls ListDir = new ls(curDir, false);
					if (!ListDir.getList().equals("")) {
						System.out.println(ListDir.getList());
					}
				}
				// else if (input.length == 2 && !handle.isPath(input[1])){
				// ls ListPath = new ls(input[1], dir, curDir, false);
				// }
				else if (input.length >= 2 && input[0].equals("ls")
						&& !(input[1].equals("-r") || input[1].equals("-R"))) {
					for (int i = 1; i < input.length; i++) {
						if (handle.isPath(input[i])) {
							ls ListPath = new ls(input[i], dir, curDir, false);
							if (!ListPath.getList().equals("")) {

								System.out.println(ListPath.getList());
							}
						} else {

							ls ListPath = new ls(curDir.toString() + input[i],
									dir, curDir, false);
							if (!ListPath.getList().equals("")) {

								System.out.println(ListPath.getList());
							}
						}

					}
				} else if (input.length == 2
						&& (input[1].equals("-r") || input[1].equals("-R"))) {

					ls ListPath = new ls(curDir, true);
					if (!ListPath.getList().equals("")) {

						System.out.println(ListPath.getList());
					}
				}

				else if (input.length >= 3
						&& (input[1].equals("-r") || input[1].equals("-R"))) {
					for (int i = 2; i < input.length; i++) {
						if (handle.isPath(input[i])) {
							ls ListPath = new ls(input[i], dir, curDir, true);
							if (!ListPath.getList().equals("")) {
								System.out.println(ListPath.getList());
							}
						} else {

							ls ListPath = new ls(curDir.toString() + input[i],
									dir, curDir, true);
							if (!ListPath.getList().equals("")) {
								System.out.println(ListPath.getList());
							}
						}
					}
				}
			} else if (input[0].equals("pwd") && input.length == 1) {
				// Case 5: "pwd"

				pwd printDir = new pwd(curDir);
				// System.out.println(cd.getCurDir());

			} else if (input[0].equals("mv") && input.length == 3) {

				// Case 6: "mv"
				// System.out.println(input[0]);
				// System.out.println(input[1] + " " + input[2]);
				mv mover = new mv();
				mover.move(input[1], input[2], dir, curDir);

			} else if (input[0].equals("get") && input.length == 2) {
				getURL addcontents = new getURL(input[1], curDir, dir);

			}

			else if (input[0].equals("cp") && input.length == 3) {
				// Case 7: "cp"
				// System.out.println(input[0]);
				// System.out.println(input[1] + " " + input[2]);
				cp copier = new cp();
				copier.copy(input[1], input[2], dir, curDir);

			} else if (input[0].equals("cat") && input.length == 2) {
				// Case 8: "cat"
				// System.out.println(input[0]);
				Cat viewContent = new Cat();
				viewContent.viewContents(input[1], dir, curDir);
				if (viewContent.getContent() != null) {

					System.out.println(viewContent.getContent());
				}

			} else if (input[0].equals("pushd") && input.length == 2) {
				pushd push = new pushd();
				curDir = push.pushAndChange(dir, curDir, input[1], fs);

			} else if (input[0].equals("popd") && input.length == 1) {
				popd pop = new popd();
				curDir = pop.popAndChange(dir, curDir, fs);

			} else if (input[0].equals("grep") && input.length > 2
					&& !input[1].toLowerCase().equals("-r")
					&& input.length % 2 == 1) {
				grep g = new grep();
				for (int i = 1; i < input.length - 1; i += 2) {
					g.doGrep(dir, curDir, input[i], input[i + 1], false);
				}
			} else if (input[0].equals("grep") && input.length > 2
					&& input[1].toLowerCase().equals("-r")
					&& input.length % 2 == 0) {
				grep g = new grep();
				for (int i = 2; i < input.length - 1; i += 2) {
					g.doGrep(dir, curDir, input[i], input[i + 1], true);
				}
			} else if (input[0].equals("echo") && content != null
					&& input[input.length - 2].equals(">")) {
				// Case 9: "echo" with ">"

				Echo contentFile = new Echo(content, input[input.length - 1],
						dir, curDir, ">");

			} else if ((input.length >= 2 && input[0].equals("rm") && !input[1]
					.equals("-f"))
					|| (input.length >= 3 && input[0].equals("rm") && input[1]
							.equals("-f"))) {
				for (int i = 1; i < input.length; i++) {

					if (input[0].equals("rm") && !input[1].equals("-f")) {
						rm Remove = new rm(input[i], dir, curDir, true);
					} else {
						if (i < input.length - 1) {
							rm Remove = new rm(input[i + 1], dir, curDir, false);
						}
					}
				}
			} else if (input[0].equals("echo") && content != null

			&& input[input.length - 2].equals(">>")) {
				// Case 10: "echo" with ">>"
				Echo contentFile = new Echo(content, input[input.length - 1],
						dir, curDir, ">>");

			} else {
				// Case 12: user enters invalid command
				System.out.println("Invalid command, please try again.");
			}
		}
	}

	// @Override
	// public String toString() {
	// return "JShell [getClass()=" + getClass() + ", hashCode()="
	// + hashCode() + ", toString()=" + super.toString() + "]";
	// }
}
