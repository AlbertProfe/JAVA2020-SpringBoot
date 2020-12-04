package com.example.shopExemple.boot.utils.controller;

public enum StatusSession {

	    CREATED  {
	        @Override
	        public String toString() {
	          return "Created";
	        }},
	    TOBUY {
	        @Override
	        public String toString() {
	          return "Tobuy";
	        }},
	    TOPAY {
	        @Override
	        public String toString() {
	          return "Topay";
	        }},
	    FINISHED{
	        @Override
	        public String toString() {
	          return "Finished";
	        }},
}