SET NOCOUNT ON
SET ANSI_NULLS ON
SET TRANSACTION ISOLATION LEVEL READ UNCOMMITTED
SET QUOTED_IDENTIFIER ON

CREATE TABLE IF NOT EXISTS network_device
(ipaddress varchar(255) NOT NULL,
 element_type varchar(255) NOT NULL,
 CONSTRAINT network_device_PK PRIMARY KEY(ipaddress));

CREATE TABLE IF NOT EXISTS neighbor
(ipaddress varchar(255) NOT NULL,
CONSTRAINT neighbor_pk PRIMARY KEY (ipaddress));

CREATE TABLE IF NOT EXISTS connection (
    network_device_ipaddress varchar(255) NOT NULL REFERENCES network_device(ipaddress) ON UPDATE CASCADE ON DELETE CASCADE,
    neighbor_ipaddress varchar(255) NOT NULL REFERENCES neighbor(ipaddress) ON UPDATE CASCADE ON DELETE CASCADE,
    cost INTEGER NOT NULL,
    UNIQUE(network_device_ipaddress, neighbor_ipaddress),
    CONSTRAINT connection_pk PRIMARY KEY(network_device_ipaddress, neighbor_ipaddress));