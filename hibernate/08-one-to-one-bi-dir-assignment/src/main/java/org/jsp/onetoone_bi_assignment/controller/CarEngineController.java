package org.jsp.onetoone_bi_assignment.controller;

import org.jsp.onetoone_bi_assignment.dao.CarEngineDao;
import org.jsp.onetoone_bi_assignment.dto.Car;
import org.jsp.onetoone_bi_assignment.dto.Engine;

public class CarEngineController {

	public static void main(String[] args) {
		
//		Inserting Car 1
		
		Car car = new Car();
		car.setCarId(1);
		car.setModel("Mustang");
		car.setManufacturer("Ford");
		car.setYear("2022");
		car.setColor("Red");
		car.setLicensePlate("MH01AB1234");
		
		Engine engine = new Engine();
		engine.setId(101);
		engine.setEngineNumber("EN123456789");
		engine.setHorsepower(450);
		engine.setFuelType("Petrol");
		engine.setDisplacement("5.0L");
		engine.setEmissionStandard("BS6");
		
//		Inserting Car 2
		
//		Car car = new Car();
//		car.setCarId(2);
//		car.setModel("Civic");
//		car.setManufacturer("Honda");
//		car.setYear("2021");
//		car.setColor("Blue");
//		car.setLicensePlate("DL05XY9876");
//		
//		Engine engine = new Engine();
//		engine.setId(102);
//		engine.setEngineNumber("EN987654321");
//		engine.setHorsepower(158);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("1.5L");
//		engine.setEmissionStandard("BS6");
		
//		Inserting Car 3
		
//		Car car = new Car();
//		car.setCarId(3);
//		car.setModel("Camry");
//		car.setManufacturer("Toyota");
//		car.setYear("2020");
//		car.setColor("Black");
//		car.setLicensePlate("KA02CD4567");
//		
//		Engine engine = new Engine();
//		engine.setId(103);
//		engine.setEngineNumber("EN192837465");
//		engine.setHorsepower(205);
//		engine.setFuelType("Hybrid");
//		engine.setDisplacement("2.5L");
//		engine.setEmissionStandard("BS6");
		
		
//		Inserting Car 4
		
//		Car car = new Car();
//		car.setCarId(4);
//		car.setModel("Altroz");
//		car.setManufacturer("Tata");
//		car.setYear("2023");
//		car.setColor("Grey");
//		car.setLicensePlate("UP32EF5678");
//		
//		Engine engine = new Engine();
//		engine.setId(104);
//		engine.setEngineNumber("EN564738291");
//		engine.setHorsepower(120);
//		engine.setFuelType("Diesel");
//		engine.setDisplacement("1.2L");
//		engine.setEmissionStandard("BS6");
		
//		Inserting Car 5
		
//		Car car = new Car();
//		car.setCarId(5);
//		car.setModel("Swift");
//		car.setManufacturer("Maruti Suzuki");
//		car.setYear("2022");
//		car.setColor("White");
//		car.setLicensePlate("RJ14GH7890");
//		
//		Engine engine = new Engine();
//		engine.setId(105);
//		engine.setEngineNumber("EN918273645");
//		engine.setHorsepower(90);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("1.0L");
//		engine.setEmissionStandard("BS6");
		
//		Inserting Car 6
		
//		Car car = new Car();
//		car.setCarId(6);
//		car.setModel("Seltos");
//		car.setManufacturer("Kia");
//		car.setYear("2023");
//		car.setColor("Silver");
//		car.setLicensePlate("WB20IJ1122");
//		
//		Engine engine = new Engine();
//		engine.setId(106);
//		engine.setEngineNumber("EN756483920");
//		engine.setHorsepower(138);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("1.4L");
//		engine.setEmissionStandard("BS6");
		
//		Inserting Car 7
		
//		Car car = new Car();
//		car.setCarId(7);
//		car.setModel("Venue");
//		car.setManufacturer("Hyundai");
//		car.setYear("2021");
//		car.setColor("Yellow");
//		car.setLicensePlate("TN09KL3344");
//		
//		Engine engine = new Engine();
//		engine.setId(107);
//		engine.setEngineNumber("EN234567890");
//		engine.setHorsepower(120);
//		engine.setFuelType("Diesel");
//		engine.setDisplacement("1.5L");
//		engine.setEmissionStandard("BS6");
		
//		Inserting Car 8
		
//		Car car = new Car();
//		car.setCarId(8);
//		car.setModel("Fortuner");
//		car.setManufacturer("Toyota");
//		car.setYear("2022");
//		car.setColor("Brown");
//		car.setLicensePlate("MP45MN5566");
//		
//		Engine engine = new Engine();
//		engine.setId(108);
//		engine.setEngineNumber("EN789456123");
//		engine.setHorsepower(204);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("2.7L");
//		engine.setEmissionStandard("BS6");
		
//		Inserting Car 9
		
//		Car car = new Car();
//		car.setCarId(9);
//		car.setModel("XUV700");
//		car.setManufacturer("Mahindra");
//		car.setYear("2023");
//		car.setColor("Black");
//		car.setLicensePlate("HR26OP7788");
//		
//		Engine engine = new Engine();
//		engine.setId(109);
//		engine.setEngineNumber("EN654321987");
//		engine.setHorsepower(200);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("2.0L");
//		engine.setEmissionStandard("BS6");
		
//		Inserting Car 10
		
//		Car car = new Car();
//		car.setCarId(10);
//		car.setModel("Baleno");
//		car.setManufacturer("Maruti Suzuki");
//		car.setYear("2020");
//		car.setColor("Blue");
//		car.setLicensePlate("GJ01QR9900");
//		
//		Engine engine = new Engine();
//		engine.setId(110);
//		engine.setEngineNumber("EN246813579");
//		engine.setHorsepower(98);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("1.2L");
//		engine.setEmissionStandard("BS6");

		
//		Updating Car 1
		
//		Car car = new Car();
//		car.setCarId(1);
//		car.setModel("Mustang");
//		car.setManufacturer("Ford");
//		car.setYear("2023");
//		car.setColor("Red");
//		car.setLicensePlate("MH01AB1234");
//		
//		Engine engine = new Engine();
//		engine.setId(101);
//		engine.setEngineNumber("EN123456789");
//		engine.setHorsepower(470);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("5.0L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Car 2
		
//		Car car = new Car();
//		car.setCarId(2);
//		car.setModel("Civic");
//		car.setManufacturer("Honda");
//		car.setYear("2022");
//		car.setColor("Blue");
//		car.setLicensePlate("DL05XY9876");
//		
//		Engine engine = new Engine();
//		engine.setId(102);
//		engine.setEngineNumber("EN987654321");
//		engine.setHorsepower(160);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("1.5L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Car 3
		
//		Car car = new Car();
//		car.setCarId(3);
//		car.setModel("Camry");
//		car.setManufacturer("Toyota");
//		car.setYear("2021");
//		car.setColor("Black");
//		car.setLicensePlate("KA02CD4567");
//		
//		Engine engine = new Engine();
//		engine.setId(103);
//		engine.setEngineNumber("EN192837465");
//		engine.setHorsepower(210);
//		engine.setFuelType("Hybrid");
//		engine.setDisplacement("2.5L");
//		engine.setEmissionStandard("BS6");
		
		
//		Updating Car 4
		
//		Car car = new Car();
//		car.setCarId(4);
//		car.setModel("Altroz");
//		car.setManufacturer("Tata");
//		car.setYear("2024");
//		car.setColor("Grey");
//		car.setLicensePlate("UP32EF5678");
//		
//		Engine engine = new Engine();
//		engine.setId(104);
//		engine.setEngineNumber("EN564738291");
//		engine.setHorsepower(130);
//		engine.setFuelType("Diesel");
//		engine.setDisplacement("1.3L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Car 5
		
//		Car car = new Car();
//		car.setCarId(5);
//		car.setModel("Swift");
//		car.setManufacturer("Maruti Suzuki");
//		car.setYear("2023");
//		car.setColor("White");
//		car.setLicensePlate("RJ14GH7890");
//		
//		Engine engine = new Engine();
//		engine.setId(105);
//		engine.setEngineNumber("EN918273645");
//		engine.setHorsepower(95);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("1.2L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Car 6
		
//		Car car = new Car();
//		car.setCarId(6);
//		car.setModel("Seltos");
//		car.setManufacturer("Kia");
//		car.setYear("2024");
//		car.setColor("Silver");
//		car.setLicensePlate("WB20IJ1122");
//		
//		Engine engine = new Engine();
//		engine.setId(106);
//		engine.setEngineNumber("EN756483920");
//		engine.setHorsepower(145);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("1.4L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Car 7
		
//		Car car = new Car();
//		car.setCarId(7);
//		car.setModel("Venue");
//		car.setManufacturer("Hyundai");
//		car.setYear("2023");
//		car.setColor("Yellow");
//		car.setLicensePlate("TN09KL3344");
//		
//		Engine engine = new Engine();
//		engine.setId(107);
//		engine.setEngineNumber("EN234567890");
//		engine.setHorsepower(125);
//		engine.setFuelType("Diesel");
//		engine.setDisplacement("1.5L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Car 8
		
//		Car car = new Car();
//		car.setCarId(8);
//		car.setModel("Fortuner");
//		car.setManufacturer("Toyota");
//		car.setYear("2024");
//		car.setColor("Brown");
//		car.setLicensePlate("MP45MN5566");
//		
//		Engine engine = new Engine();
//		engine.setId(108);
//		engine.setEngineNumber("EN789456123");
//		engine.setHorsepower(220);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("3.0L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Car 9
		
//		Car car = new Car();
//		car.setCarId(9);
//		car.setModel("XUV700");
//		car.setManufacturer("Mahindra");
//		car.setYear("2024");
//		car.setColor("Black");
//		car.setLicensePlate("HR26OP7788");
//		
//		Engine engine = new Engine();
//		engine.setId(109);
//		engine.setEngineNumber("EN654321987");
//		engine.setHorsepower(205);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("2.0L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Car 10
		
//		Car car = new Car();
//		car.setCarId(10);
//		car.setModel("Baleno");
//		car.setManufacturer("Maruti Suzuki");
//		car.setYear("2021");
//		car.setColor("Blue");
//		car.setLicensePlate("GJ01QR9900");
//		
//		Engine engine = new Engine();
//		engine.setId(110);
//		engine.setEngineNumber("EN246813579");
//		engine.setHorsepower(110);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("1.2L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Engine alone
		
//		Updating Engine 1
		
//		Engine engine = new Engine();
//		engine.setId(101);
//		engine.setEngineNumber("EN123456789");
//		engine.setHorsepower(470);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("5.0L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Engine 2
		
//		Engine engine = new Engine();
//		engine.setId(102);
//		engine.setEngineNumber("EN987654321");
//		engine.setHorsepower(160);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("1.5L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Engine 3
		
//		Engine engine = new Engine();
//		engine.setId(103);
//		engine.setEngineNumber("EN192837465");
//		engine.setHorsepower(210);
//		engine.setFuelType("Hybrid");
//		engine.setDisplacement("2.5L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Engine 4
		
//		Engine engine = new Engine();
//		engine.setId(104);
//		engine.setEngineNumber("EN564738291");
//		engine.setHorsepower(120);
//		engine.setFuelType("Diesel");
//		engine.setDisplacement("1.2L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Engine 5
		
//		Engine engine = new Engine();
//		engine.setId(105);
//		engine.setEngineNumber("EN918273645");
//		engine.setHorsepower(90);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("1.0L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Engine 6
		
//		Engine engine = new Engine();
//		engine.setId(106);
//		engine.setEngineNumber("EN756483920");
//		engine.setHorsepower(138);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("1.4L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Engine 7
		
//		Engine engine = new Engine();
//		engine.setId(107);
//		engine.setEngineNumber("EN234567890");
//		engine.setHorsepower(120);
//		engine.setFuelType("Diesel");
//		engine.setDisplacement("1.5L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Engine 8
		
//		Engine engine = new Engine();
//		engine.setId(108);
//		engine.setEngineNumber("EN789456123");
//		engine.setHorsepower(204);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("2.7L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Engine 9
		
//		Engine engine = new Engine();
//		engine.setId(109);
//		engine.setEngineNumber("EN654321987");
//		engine.setHorsepower(200);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("2.0L");
//		engine.setEmissionStandard("BS6");
		
//		Updating Engine 10
		
//		Engine engine = new Engine();
//		engine.setId(110);
//		engine.setEngineNumber("EN246813579");
//		engine.setHorsepower(98);
//		engine.setFuelType("Petrol");
//		engine.setDisplacement("1.2L");
//		engine.setEmissionStandard("BS6");
		
		CarEngineDao dao = new CarEngineDao();
		
//		Case-1
//		Car has Engine as well as Engine has Car
		car.setEngine(engine);
		engine.setCar(car);
//		dao.saveCar(car);
		
//		Case-2
//		Engine has Car as well as Car has Engine
//		car.setEngine(engine);
//		engine.setCar(car);
//		dao.saveEngine(engine);
		
//		Case-3
//		Car has Engine but Engine does not have Car
//		car.setEngine(engine);
//		dao.saveCar(car);
		
//		Case-4
//		Engine has Car but Car does not have Engine
//		engine.setCar(car);
//		dao.saveEngine(engine);
		
//		Finding Car by id
//		dao.findCarById(1);
//		dao.findCarById(2);
//		dao.findCarById(3);
//		dao.findCarById(4);
//		dao.findCarById(5);
//		dao.findCarById(6);
//		dao.findCarById(7);
//		dao.findCarById(8);
//		dao.findCarById(9);
//		dao.findCarById(10);
//		dao.findCarById(11);
		
//		Finding Engine by id
//		dao.findEngineById(101);
//		dao.findEngineById(102);
//		dao.findEngineById(103);
//		dao.findEngineById(104);
//		dao.findEngineById(105);
//		dao.findEngineById(106);
//		dao.findEngineById(107);
//		dao.findEngineById(108);
//		dao.findEngineById(109);
//		dao.findEngineById(110);
//		dao.findEngineById(111);
		
//		Displaying all the Cars at once
		dao.fetchAllCars();
		
//		Displaying all the Engines at once
//		dao.fetchAllEngines();
		
//		Updating Car
		
//		Case-1
//		Car has Engine as well as Engine has Car
//		car.setEngine(engine);
//		engine.setCar(car);
//		dao.updateCarById(car);
		
//		Case-2
//		Engine has Car as well as Car has Engine
//		car.setEngine(engine);
//		engine.setCar(car);
//		dao.updateEngineById(engine);
		
//		Case-3
//		Car has Engine but Engine does not have Car
//		car.setEngine(engine);
//		dao.updateCarById(car);
		
//		Case-4
//		Engine has Car but Car does not have Engine
//		engine.setCar(car);
//		dao.updateEngineById(engine);
		
//		Updating Engine alone
//		dao.updateEngineById(engine);
		
//		Deleting Cars and Engines
//		dao.deleteCarById(1);
//		dao.deleteEngineById(102);
//		dao.deleteCarById(3);
		
//		If there is no relation then delete individually
//		dao.deleteEngineById(104);
//		dao.deleteCarById(4);
//		OR
//		dao.deleteCarById(4);
//		dao.deleteEngineById(104);
		
//		dao.deleteEngineById(111);
	}
}