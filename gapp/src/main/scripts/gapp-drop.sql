/* Additional Department Field Value */
ALTER TABLE additional_dept_field_values
	DROP CONSTRAINT FK_5a5xd8gm55ba8qvdwpkn6v5y6,
	DROP CONSTRAINT FK_2so36ex55wv7de4nipolur7cy;
DROP TABLE additional_dept_field_values;

/* Additional Department Fields */
ALTER TABLE additional_dept_fields
	DROP CONSTRAINT FK_pcdxv35ypsxhar2rciipywy4e,
	DROP CONSTRAINT FK_nvbpe1p7o22780l4qwpv1s0o9;
DROP TABLE additional_dept_fields;

/* Application Status Changes */
ALTER TABLE application_status_changes
	DROP CONSTRAINT FK_5wm3q59j1gp17os9pm0197f0w,
	DROP CONSTRAINT FK_3k3vkat1anih0fan4fd1vddo3;
DROP TABLE application_status_changes;

/* educational backgrounds */
ALTER TABLE educational_backgrounds
	DROP CONSTRAINT FK_hbmsvo9a8tvu79hr6k1mc40wj;
DROP TABLE educational_backgrounds;

/* applications */
ALTER TABLE applications
	DROP CONSTRAINT FK_bluanikenmrafi5adj9w2oivc,
	DROP CONSTRAINT FK_pafwqn7jpfl3pdmk3kp8s69x0;
DROP TABLE applications;

/* programs */
ALTER TABLE programs
	DROP CONSTRAINT FK_9oac0l8t3j02ck4s7ah0o4676;
DROP TABLE programs;


/* application status */
DROP TABLE application_status;

/* departments */ 
DROP TABLE departments;

/* system users */
DROP TABLE system_users;

/* Sequence*/
DROP SEQUENCE hibernate_sequence;