package q8;
abstract class Move{
	int x,y;
	abstract void move(int x, int y) ;
	void stop() {};

}
class Marine extends Move { // 보병
	void stimPack() { /* .*/}

@Override
void move(int x, int y) {
	// TODO Auto-generated method stub
	
}


}

class Tank extends  Move { // 탱크
	void changeMode() { /* . */}

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		
	} 

}

class Dropship extends Move { // 수송선
	void load() {};
	void unload() {}
	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		
	};
}