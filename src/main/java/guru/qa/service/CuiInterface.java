package guru.qa.service;

import guru.qa.domain.Car;
import guru.qa.domain.Track;
import guru.qa.repo.CarStore;
import guru.qa.repo.TrackStore;

import javax.swing.*;
import java.util.Scanner;

public class CuiInterface extends Interface{
    private final CarStore carStore;
    private final TrackStore trackStore;
    private final Scanner sc = new Scanner(System.in);

    public CuiInterface(CarStore carStore, TrackStore trackStore) {
        this.carStore = carStore;
        this.trackStore = trackStore;
    }

    @Override
    public Car chooseCar() {
        System.out.print("Car: ");
        String desiredCar = sc.nextLine();
        return carStore.lookup(desiredCar);
    }

    @Override
    public Track chooseTrack() {
        System.out.print("Track: ");
        String desiredTrack = sc.nextLine();
        return trackStore.lookup(desiredTrack);
    }

    @Override
    public void showResult(Car car, Track track) {
        if (car.isPitstopNeeded(track)) {
            System.out.println("Результат:\nPit-stop needed in "+car.maxLapsForTrack());
        } else {
            System.out.println("Результат:\nPit-stop not needed");
        }
    }
}