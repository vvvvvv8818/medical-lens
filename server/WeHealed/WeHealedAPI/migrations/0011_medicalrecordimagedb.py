# -*- coding: utf-8 -*-
# Generated by Django 1.11.12 on 2018-09-05 14:27
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('WeHealedAPI', '0010_ruledataset'),
    ]

    operations = [
        migrations.CreateModel(
            name='MedicalRecordImageDB',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('filename', models.CharField(max_length=200)),
                ('image', models.ImageField(upload_to='MedicalRecordImages/')),
            ],
        ),
    ]
