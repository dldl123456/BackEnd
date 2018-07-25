package video.note.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorListTest {
	public static void main(String[] args) {
		ListIteratorListTest d = new ListIteratorListTest();
		d.ListTest();
	}
	
	public void ListTest() {
		boolean doExceptionTest = false;
		List<Phone> phones = new ArrayList<Phone>();
		phones.add(new Phone("111"));
		phones.add(new Phone("183"));
		phones.add(new Phone("182"));
		phones.add(new Phone("185"));

		System.out.println("原始数据");
		for (Phone phoneElem : phones) {
			System.out.println(phoneElem.getNumber());
		}

		ListIterator<Phone> phoneIterator = phones.listIterator();
		while (phoneIterator.hasNext()) {
			Phone tmpPhone = phoneIterator.next();
			if (tmpPhone.getNumber().equals("111")) {
				tmpPhone.setNumber("666");
				phoneIterator.set(tmpPhone);
				phoneIterator.add(new Phone("132")); // use ListIterator add
														// item is ok
			}
			if (tmpPhone.getNumber().equals("183")) {
				phoneIterator.remove();
			}

			if (doExceptionTest) {
				phones.add(new Phone("170")); // throw
				// java.util.ConcurrentModificationException
			}
		}

		System.out.println("\n修改后正向遍历：");
		for (Phone phoneElem : phones) {
			System.out.println(phoneElem.getNumber());
		}

		System.out.println("\n修改后反向遍历：");
		// 反向遍历
		while (phoneIterator.hasPrevious()) {
			System.out.println(phoneIterator.previousIndex() + ": " + phoneIterator.previous().getNumber());
		}
	}

}

class Phone {
	private String number;

	public Phone() {
	}

	public Phone(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
