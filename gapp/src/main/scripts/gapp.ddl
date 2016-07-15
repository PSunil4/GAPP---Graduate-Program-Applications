
    create table additional_dept_field_values (
        id int4 not null,
        additional_field_value varchar(255),
        additionalDeptField_id int4,
        application_application_id int4,
        primary key (id)
    );

    create table additional_dept_fields (
        id int4 not null,
        field_name varchar(255),
        field_value_type varchar(255),
        isActive boolean not null,
        isfield_required boolean,
        department_department_id int4,
        systemStaff_user_id int4,
        primary key (id)
    );

    create table application_status (
        app_status_id int4 not null,
        status_name varchar(255),
        primary key (app_status_id)
    );

    create table application_status_changes (
        id int4 not null,
        applicationStatus varchar(255),
        comment varchar(255),
        time_of_status timestamp,
        application_application_id int4,
        user_user_id int4,
        primary key (id)
    );

    create table applications (
        application_id int4 not null,
        gpa float8,
        toefl_score int4,
        transcript varchar(255),
        app_birthdate date,
        cin int4,
        app_citizenship varchar(255),
        app_email varchar(255),
        app_gender varchar(255),
        app_lastname varchar(255),
        phone_number varchar(255),
        app_firstname varchar(255),
        applicationStatus varchar(255),
        application_term varchar(255),
        date_of_submission timestamp,
        international boolean not null,
        programToApply_program_id int4,
        user_user_id int4,
        primary key (application_id)
    );

    create table departments (
        department_id int4 not null,
        department_name varchar(255),
        primary key (department_id)
    );

    create table educational_backgrounds (
        id int4 not null,
        degree_earned varchar(255),
        major_of_degree varchar(255),
        name_of_institute varchar(255),
        time_period_attended varchar(255),
        studentApplication_application_id int4,
        primary key (id)
    );

    create table programs (
        program_id int4 not null,
        isActive boolean not null,
        program_name varchar(255),
        department_department_id int4,
        primary key (program_id)
    );

    create table system_users (
        user_id int4 not null,
        email varchar(255) not null,
        firstname varchar(255) not null,
        lastname varchar(255) not null,
        password varchar(255) not null,
        type_of_user varchar(255),
        primary key (user_id)
    );

    alter table system_users 
        add constraint UK_dxy6tf9nvg7o3kd7yfd5j7qiu unique (email);

    alter table additional_dept_field_values 
        add constraint FK_5a5xd8gm55ba8qvdwpkn6v5y6 
        foreign key (additionalDeptField_id) 
        references additional_dept_fields;

    alter table additional_dept_field_values 
        add constraint FK_2so36ex55wv7de4nipolur7cy 
        foreign key (application_application_id) 
        references applications;

    alter table additional_dept_fields 
        add constraint FK_pcdxv35ypsxhar2rciipywy4e 
        foreign key (department_department_id) 
        references departments;

    alter table additional_dept_fields 
        add constraint FK_nvbpe1p7o22780l4qwpv1s0o9 
        foreign key (systemStaff_user_id) 
        references system_users;

    alter table application_status_changes 
        add constraint FK_5wm3q59j1gp17os9pm0197f0w 
        foreign key (application_application_id) 
        references applications;

    alter table application_status_changes 
        add constraint FK_3k3vkat1anih0fan4fd1vddo3 
        foreign key (user_user_id) 
        references system_users;

    alter table applications 
        add constraint FK_pafwqn7jpfl3pdmk3kp8s69x0 
        foreign key (programToApply_program_id) 
        references programs;

    alter table applications 
        add constraint FK_bluanikenmrafi5adj9w2oivc 
        foreign key (user_user_id) 
        references system_users;

    alter table educational_backgrounds 
        add constraint FK_hbmsvo9a8tvu79hr6k1mc40wj 
        foreign key (studentApplication_application_id) 
        references applications;

    alter table programs 
        add constraint FK_9oac0l8t3j02ck4s7ah0o4676 
        foreign key (department_department_id) 
        references departments;

    create sequence hibernate_sequence;
