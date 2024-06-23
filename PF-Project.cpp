#include<iostream>
#include<string>
#include<cstdlib>
using namespace std;
int j = 0;
int secretkey = 000;
struct user {
	string istname;
	string _2ndname;
	string email;
	string age;
	string gender;
	string phone;
	string pass;
	string inbox;
};

string message;
user app[100];
void menu() {
	cout << "\t_1 press 1 to sign up" << endl;
	cout << "\t_2 press 2 to login" << endl;
	cout << "\t_press 5 for view details  accounts #remember to enter secret key else accounts details will not show up" << endl;
	cout << "********************************************************" << endl;
}
void addrecord() {
	cout << "_______________________________" << endl;
	cout << "enter your ist name" << endl;
	cin >> app[j].istname;
	cout << "enter your 2nd name" << endl;
	cin >> app[j]._2ndname;
	cout << "enter your email" << endl;
	cin >> app[j].email;
	cout << "enter your password" << endl;
	cin >> app[j].pass;
	cout << "enter your age" << endl;
	cin >> app[j].age;
	cout << "enter your gender" << endl;
	cin >> app[j].gender;
	cout << "enter your phone" << endl;
	cin >> app[j].phone;
	cout << endl;
	cout << "__________________________________________________" << endl;
	cout << "congrats you have sucessfully registered" << endl;
	cout << "___________________________________________________ " << endl;
	j++;
}
void view() {
	int keyview;
	cout << "enter secret view to view" << endl;
	cin >> keyview;
	for (int i = 0; i < j; i++) {
		cout << "first name= " << app[i].istname << endl;
		cout << "_2ndname" << app[i]._2ndname << endl;;
		cout << "email=" << app[i].email << endl;;
		cout << "password= " << app[j].pass << endl;;
		cout << "age=" << app[i].age << endl;
		cout << "gender= " << app[i].gender << endl;;
		cout << "phone= " << app[i].phone << endl;
	}
}
void login() {
	bool found = 0;
	string mail2, pass2;
	cout << "enter your email" << endl;
	cin >> mail2;
	cout << "enter your password" << endl;
	cin >> pass2;
	for (int i = 0; i < j; i++) {
		if (mail2 == app[i].email && pass2 == app[i].pass) {
			cout << "congrats you have sucessfully login" << endl;
			cout << " \ta_press 3 to delete account" << endl;
			cout << "\tb_ press 4 to send items" << endl;
			cout << "    INBOX(recieved message)        " << endl;
			cout << "__________________________________________________________________________" << endl;
			cout << app[i].inbox;
			cout << "_______________________________________" << endl;
			found = 1;

		}

	}
	if (found == 0) {
		cout << "invalid password or email" << endl;
	}
}
void delacc() {
	bool found = 0;
	string maildel;
	cout << "Are you sure you want to delte your account????????????" << endl;
	cout << " <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<  " << endl;
	cout << "enter your mail for confirmation" << endl;
	cin >> maildel;
	string passdel;
	cout << "enter your password for confirmation" << endl;
	cin >> passdel;

	for (int i = 0; i <j; i++) {
		bool found = 0;
		if (maildel == app[i].email && passdel == app[i].pass) {
			cout << "account sucessfully delted " << endl;
			cout << "=======================================================================" << endl;
			app[i].istname = '0';
			app[i]._2ndname = '0';
			app[i].pass = '0';
			app[i].age = '0';
			app[i].phone = '0';
			app[i].gender = '0';
			app[i].email = '0';
			found = 1;
		}

	}
	if (found == 0) {

		cout << "account not found" << endl;

	}

}
void sendmsg() {
	bool found = 0;
	int count = 1;
	cout << "enter mail of the user to send msg" << endl;
	string mailrec;
	cin >> mailrec;
	cin.ignore();
	cout << "enter your message" << endl;
	getline(cin,message);
	for (int i = 0; i < j; i++) {

		if (app[i].email == mailrec) {
			app[i].inbox = message;
			while (count < 2) {
				cout << "your message has been sent" << endl;
				count++;
				found = 1;
			
			}

		}



	}
	if (found == 0) {
		cout << "failed to send message" << endl;
	}
}


int main() {

	int  choice;
	do {
		menu();
		cin >> choice;
		switch (choice) {
		case 1:
			addrecord();
			break;
		case 2:
			login();
			break;
		case 3:
			delacc();
			break;
		case 4:
			sendmsg();
			break;
	
		case 5:
			view();
			break;
		}
	} while (-1);
	system("pause");
	return 0;
}
