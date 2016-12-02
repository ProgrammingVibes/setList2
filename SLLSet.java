package setList2;
class SLLNode{
	int value;
	SLLNode next;
	public SLLNode(int x, SLLNode y){
		value=x;
		next=y;
	}
}
public class SLLSet {
	private int size;
	private SLLNode head;
	public SLLSet(){
		head=new SLLNode(0,null);
		size=0;
	}
	public SLLSet(int[] sortedArray){
		head=new SLLNode(0,null);
		SLLNode p=head;
		for(int i=0;i<sortedArray.length;i++){
			p.next=new SLLNode(sortedArray[i],null);
			p=p.next;
		}
		size=sortedArray.length;
	}
	int getSize(){
		return(size);
	}
	public SLLSet copy(){
		SLLSet q=new SLLSet();
		SLLNode p=head;
		SLLNode r=q.head;
		while(p.next!=null){
			r.next=new SLLNode(p.next.value,null);
			p=p.next;
			r=r.next;
			q.size+=1;
		}
		return(q);
		
		
	}
	public boolean isIn(int v){
		SLLNode p=head;
		while(p.next!=null){
			if(p.next.value==v){
				return(true);
			}
			p=p.next;
		}
		return(false);
	}
	
	public void add(int v){
		SLLNode p=head;
		SLLNode q;
		if(p.next==null){
			q=new SLLNode(v,null);
			p.next=q;
			size+=1;
		}
		p=head;
		while(p.next!=null){
			if(p.next.value==v){
				break;
			}
			else if(p.next.value>v){
				q=new SLLNode(v,p.next);
				p.next=q;
				size+=1;
				break;
		}
			else if(p.next.next==null){
				q=new SLLNode(v,null);
				p.next.next=q;
				size+=1;
				break;
			}
			p=p.next;
	}
	}
	
	public void remove(int v){
		SLLNode p=head;
		while(p.next!=null){
			if(p.next.value==v){
				p.next=p.next.next;
				size-=1;
				break;
			}
			
			p=p.next;
		} 
	}
	
	public SLLSet union(SLLSet s){
		SLLSet U=new SLLSet();
		SLLNode p=head;
		while(p.next!=null){
			U.add(p.next.value);
			p=p.next;
		}
		p=s.head;
		while(p.next!=null){
			U.add(p.next.value);
			p=p.next;
		}
		return(U);
	}
	public SLLSet intersection(SLLSet s){
		SLLSet sizeSet;
		SLLSet I=new SLLSet();
		SLLNode p;
		if(s.getSize()>this.size){
			sizeSet=this.copy();
		}
		else{
			sizeSet=s.copy();
		}
		p=sizeSet.head;
		while(p.next!=null){
			if(this.isIn(p.next.value)&& s.isIn(p.next.value)){
				I.add(p.next.value);
			}
			p=p.next;
		}
		return(I);
		
	}
	
	public SLLSet difference(SLLSet s){
		SLLNode p=head;
		SLLSet D=new SLLSet();
		while(p.next!=null){
			if(this.isIn(p.next.value)^s.isIn(p.next.value)){
				D.add(p.next.value);
			}
			p=p.next;
		}
		return(D);
		
	}
	
	public String toString(){
		String s=new String();
		s+="{";
		SLLNode p=head;
		while(p.next!=null){
			s+=p.next.value;
			s+=" ";
			p=p.next;
		}
		s+="}";
		return(s);
	}

	public static void main(String[] args) {
		int[] sort={3,4,6,8};
		SLLSet set2=new SLLSet(sort);
		SLLSet set3=set2.copy();
		set3.add(1);
		System.out.println(set3.getSize());
		System.out.println(set2.getSize());
		System.out.println(set3.toString());
		System.out.println(set2.toString());
		int[] set4con={7,10,11,15};
		SLLSet set4=new SLLSet(set4con);
		SLLSet set5=set3.union(set4);
		System.out.println(set4);
		System.out.println(set5.toString());
		System.out.println(set5.getSize());
		SLLSet set6=set4.intersection(set3);
		System.out.println(set6);
		System.out.println(set6.getSize());
		SLLSet set7=set2.difference(set3);
		System.out.println(set7);

	}

}
