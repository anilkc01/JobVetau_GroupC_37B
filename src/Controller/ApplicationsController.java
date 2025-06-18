/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.applicationData;
import Model.appliedJobData;
import Model.seekerData;
import View.*;
import dao.dao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.ImageIcon;
import static junit.runner.Version.id;

/**
 *
 * @author thismac
 */
public class ApplicationsController {

    private final Applications apps;
    private final dao uDao = new dao();
    private final int jId;
    private final ArrayList<applicationData> applications;
    private applicationData cApplication = null;

    public ApplicationsController(Applications apps, int jId) {
        this.applications = uDao.getApplications(jId);
        this.cApplication = applications.get(0);
        this.apps = apps;
        this.jId = jId;
        this.apps.acceptListener(new accept());
        this.apps.rejectListener(new reject());
        setList();
        setPanel(applications.get(0).getSeekerId());

    }

    public void setList() {

        apps.applicantList.removeAll();
        for (applicationData application : applications) {

            seekerData seeker = uDao.getSeekerData(application.getSeekerId());
            applicantCard jobPanel = new applicantCard(seeker);

            jobPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                    cApplication = application;
                    setPanel(seeker.getId());
                }
            });
            apps.applicantList.add(jobPanel);
            apps.applicantList.add(Box.createVerticalStrut(10));
        }

        apps.applicantList.revalidate();
        apps.applicantList.repaint();
        apps.Title.setText("");
    }

    public void setPanel(int skrID) {
        seekerData seeker = uDao.getSeekerData(skrID);

        if (cApplication.getStatus().equals("Accepted")) {
            apps.acceptBtn.setEnabled(false);
            apps.rejectBtn.setEnabled(true);
        } else if (cApplication.getStatus().equals("Rejected")) {
            apps.acceptBtn.setEnabled(true);
            apps.rejectBtn.setEnabled(false);
        } else {
            apps.acceptBtn.setEnabled(true);
            apps.rejectBtn.setEnabled(true);
        }

        apps.skrName.setText(seeker.getName());
        apps.skrID.setText(seeker.getIdNo());
        apps.skrContact.setText(seeker.getNumber());
        apps.skrEmail.setText(seeker.getEmail());
        apps.skrAddress.setText(seeker.getAddress());
        apps.skrDOB.setText(seeker.getDOB());
        apps.skrExp.setText(seeker.getExperience());
        apps.skrSpecialization.setText(seeker.getSpecialization());
        apps.skrPortfolio.setText(seeker.getProtfolio());

        String path = seeker.getPhoto();
        if (path != null && !path.isEmpty()) {
            try {
                ImageIcon icon = new ImageIcon(path);
                apps.skrImage.setIcon(icon);
            } catch (Exception e) {
                apps.skrImage.setIcon(new ImageIcon(getClass().getResource("/Assets/skrLogo.png")));
            }
        } else {
            apps.skrImage.setIcon(new ImageIcon(getClass().getResource("/Assets/skrLogo.png")));
        }
    }

    private class accept implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            uDao.updateStatus(cApplication.getId(), "Accepted");
            apps.acceptBtn.setEnabled(false);
            apps.rejectBtn.setEnabled(true);
        }

    }

    private class reject implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            uDao.updateStatus(cApplication.getId(), "Rejected");
            apps.acceptBtn.setEnabled(true);
            apps.rejectBtn.setEnabled(false);

        }

    }

}
